import React, {useEffect, useState} from 'react';
import Amplify, {API, Auth} from 'aws-amplify';
import {Typography, Spin, Menu, Table, Layout, Space, Switch, Button, Input} from "antd";
import {PlusOutlined, UserOutlined, LogoutOutlined, StarTwoTone} from '@ant-design/icons';
import {onAuthUIStateChange} from "@aws-amplify/ui-components";
import "./index.css";
import "antd/dist/antd.css";
import _ from 'lodash';

const {Paragraph} = Typography;

const App = () => {
  const [user, setUser] = useState();
  const [tableLoading, setTableLoading] = useState(true);
  const [loading, setLoading] = useState(false);
  const [emailMappings, setEmailMappings] = useState([]);
  const [originalEmailMappings, setOriginalEmailMappings] = useState([]);
  const [cursor, setCursor] = useState(null);
  const [loadMore, setLoadMore] = useState(false);


  const showNotification = (email) => {
    console.log('Notifying of copy for:', email);
    window.chrome.notifications.create(
        'shadowlayer-copy',
        {
          type: 'basic',
          title: 'Email Copied to Clipboard',
          message: email,
          iconUrl: 'logo192.png'
        },
        console.log
    );
  }

  const handleFilter = _.debounce(
      (query) => {
        if (query.length > 3) {
          setLoadMore(true);

          if (originalEmailMappings.length === 0) {
            setOriginalEmailMappings([...emailMappings]);
          }

          API
              .get('ShadowLayerAPI', '/email-mapping', {queryStringParameters: {query}})
              .then(({error, data, cursor}) => {
                if (error) {
                  console.log(error);
                } else {
                  setEmailMappings(data);
                }
                setLoadMore(false);
              })
              .catch((error) => {
                console.log(error);
                setLoadMore(false);
              });
        } else if (originalEmailMappings.length !== 0) {
          setEmailMappings([...originalEmailMappings]);
          setOriginalEmailMappings([]);
        }
      },
      500,
      {trailing: true}
  );

  useEffect(() => {
    API
        .get('ShadowLayerAPI', '/email-mapping', {})
        .then(({data, error, cursor}) => {
          if (error) {
            console.error(error);
          } else {
            setCursor(cursor);
            setEmailMappings(data);
          }
          setTableLoading(false);
        })
        .catch((error) => {
          console.error(error);
          setTableLoading(false);
        });

    return onAuthUIStateChange((nextAuthState, authData) => {
      setUser(authData);
    });
  }, []);

  const handleScroll = (e) => {
    e.preventDefault();
    const div = e.target;
    const scrollBottom = div.scrollHeight - (div.clientHeight + div.scrollTop);

    if (!_.isEmpty(cursor) && scrollBottom === 0) {
      setLoadMore(true);
      API
          .get('ShadowLayerAPI', '/email-mapping', {queryStringParameters: {cursor}})
          .then(({data: newData, error, cursor}) => {
            if (error) {
              console.error(error);
            } else {
              setCursor(cursor);
              setEmailMappings([...emailMappings, ...newData]);
            }
            setLoadMore(false);
          })
          .catch((error) => {
            console.error(error);
            setLoadMore(false);
          });
    }
  }

  const handleOnChange = (email, index, enabled, e) => {
    e.preventDefault();
    API
        .put('ShadowLayerAPI', `/email-mapping/${email}`, {body: {index, enabled}})
        .then(({error, data}) => {
          if (error) {
            console.error(error);
          } else {
            const newEmailMappings = [...emailMappings];
            newEmailMappings[index] = data;
            setEmailMappings(newEmailMappings);
          }
        })
        .catch((error) => {
          console.error(error.toString());
        });
  }

  const handleGenerateEmail = (e) => {
    e.preventDefault();
    setLoading(true);
    API
        .post('ShadowLayerAPI', '/email-mapping/generate', {body: {email: 'generate'}})
        .then(({error, data}) => {
          if (error) {
            console.error(error);
          } else {
            data.isNew = true;
            setEmailMappings([data, ...emailMappings]);
          }
          setLoading(false);
        })
        .catch((error) => {
          console.error(error.toString());
          setLoading(false);
        });
  }

  const columns = [
    {
      dataIndex: "email",
      width: '100%',
      render: (text, {isNew}) => {
        return (
            <Paragraph ellipsis copyable={{text}} style={{padding: 0, margin: 0, width: '100%'}}>
              {isNew && <StarTwoTone twoToneColor={'#ffdd99'}/>} &nbsp; {text}
            </Paragraph>
        )
      }
    },
    {
      dataIndex: "enabled",
      width: 50,
      render: (text, {email, enabled, isNew = false}, index) => (
          <>
            <Switch
                size="small"
                toggle
                checked={enabled}
                onClick={handleOnChange.bind(null, email, index)}
            />
          </>
      )
    }
  ];

  if (user === undefined || tableLoading) {
    return (
        <div style={{
          height: '100vh',
          textAlign: 'center',
          display: 'flex',
          justifyContent: 'center',
          alignItems: 'center'
        }}>
          <Spin size={'large'}/>
        </div>
    );
  }

  return (
        <Layout style={{height: '100vh',width: '800px'}}>
          <Layout.Header style={{
            padding: 0,
            backgroundColor: 'white',
            height: 60,
            borderBottom: '1px solid #ccc',
            marginBottom: 5
          }}>
            <Menu>
              <Input placeholder="Filters Emails..." style={{width: 259}} bordered={false}
                     onChange={(e) => handleFilter(e.target.value)}/>
              <Button size="small" type="primary" shape="circle" icon={<PlusOutlined/>} color={'red'}
                      onClick={handleGenerateEmail} style={{float: 'right', margin: 18}}
                      loading={loadMore || loading}/>
            </Menu>
          </Layout.Header>
          <Layout.Content style={{height: '100px',width: '800px', overflowY: 'auto', overflowX: 'hidden'}} onScroll={handleScroll}>
            <Table
                pagination={false}
                columns={columns}
                dataSource={emailMappings}
                showHeader={false}
                //size={'small'}
            />
          </Layout.Content>
          {/*<Layout.Footer style={{padding: 0}}>
                <div style={{float: 'left', margin: '16px 18px 16px 18px'}}>
                    Hi, &nbsp; <strong>{user.attributes.name}!</strong>
                </div>
                <Menu theme={'light'} mode={'horizontal'} style={{textAlign: 'right'}}>
                    <Menu.Item onClick={() => window.open(process.env.REACT_APP_SHADOWLAYER_WEB_URL)}
                               icon={<UserOutlined color={'blue'}/>}/>
                    <Menu.Item onClick={() => Auth.signOut({global: true}).then(() => window.location.reload())}
                               icon={<LogoutOutlined color={'red'}/>}/>
                </Menu>
            </Layout.Footer>*/}
        </Layout>
  );
}

export default App;
