create table orders (id bigint not null auto_increment, baggage bit, order_cost varchar(255), timestamp varchar(255), route_id bigint, user_id bigint, primary key (id)) engine=InnoDB;
create table planes (id bigint not null auto_increment, model varchar(255), side_number varchar(255), primary key (id)) engine=InnoDB;
create table routes (id bigint not null auto_increment, arrival varchar(255), departure varchar(255), qty_count varchar(255), route_cost varchar(255), timestamp varchar(255), plane_id bigint, primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, number varchar(255), pass varchar(255), primary key (id)) engine=InnoDB;
alter table orders add constraint FK6wuyx1giqf3cs3yu9cc3oaiun foreign key (route_id) references routes (id);
alter table orders add constraint FKel9kyl84ego2otj2accfd8mr7 foreign key (user_id) references user (id);
alter table routes add constraint FK7npmlyqbtsmkaak3t0rxb9stk foreign key (plane_id) references planes (id);
create table users (id bigint not null auto_increment, number varchar(255), pass varchar(255), primary key (id)) engine=InnoDB;
alter table orders add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users (id);
