create table `shop`(
    `id` bigint(20) not null auto_increment,
    `name` varchar(10) not null,
    `create_time` datetime,
    `last_modified` datetime,
    `expiration` datetime,
    `status` int(1) default '0',
    unique key(`name`),
    primary key(`id`)
);

create table `user_admin`(
    `id` bigint(20) not null auto_increment,
    `name` varchar(10) not null,
    `create_time` datetime,
    `last_modified` datetime,
    `password` varchar(20),
     unique key(`name`),
     primary key(`id`)
);