CREATE TABLE rframework.user
(
  uid int PRIMARY KEY NOT NULL,
  name varchar (255) NOT NULL,
  sex int default 0 NOT NULL,
  userLock int default 0 NOT NULL,
  password varchar (255) NOT NULL,
  address varchar (255),
  email varchar (255),
  cellPhone varchar (255),
  wechat varchar (255),
  createTime TIMESTAMP ,
  modifyTime TIMESTAMP ,
  isDeleted int DEFAULT 0 NOT NULL
);