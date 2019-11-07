# 建立项目数据库的表

# Module  One    权限模块 [RBAC设计模式去设计表，非常灵活，扩展性好]
airsys_user  

# Module  Two   人资模块  [其实没有统一的标准，就是根据实际情况设置表]



# Module  Three  行政模块  考勤管理  车辆管理  办公用品管理


# 例子模块
create table if not  exists  account(
	
);
create table if not exists user(
	id int primary key auto_increment,
	name varchar(20) not null,
	age integer
);
insert into user(name,age) values("aa",10);
insert into user(name,age) values("bb",20);
insert into user(name,age) values("cc",30);




