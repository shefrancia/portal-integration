create database uportaldb;
use uportaldb

create table users(
	userid int not null auto_increment,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	email varchar(100) not null,
	username varchar(100) not null,
	password varchar(100) not null,
	enabled tinyint(1) default true,
	collegeid int default null,
	departmentid int default null,
	courseid int default null,
	primary key(userid)	
)ENGINE = InnoDB;

create table userTypes(
	typeid int not null auto_increment,
	typename varchar(15) not null,
	primary key(typeid)
)ENGINE = InnoDB;

create table roles(
	roleid int not null auto_increment,
	rolename varchar(20) not null,
	primary key(roleid)
)ENGINE = InnoDB;

create table rolesPerType(
	roleid int not null,
	typeid int not null,
	constraint fk_typeid foreign key (typeid)
	references userTypes(typeid),
	constraint fk_roleid foreign key (roleid)
	references roles(roleid)
)ENGINE = InnoDB;

create table userRoles(
	userid int not null,
	typeid int not null,
	constraint fk_ur_userid foreign key (userid)
	references users(userid),
	constraint fk_ur_typeid foreign key (typeid)
	references userTypes(typeid)
)ENGINE = InnoDB;

grant all privileges on uportaldb.users to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.userTypes to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.roles to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.userRoles to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.rolesPerType to 'java'@'localhost' with grant option;

insert into userTypes (typename) value ('GENERAL');
insert into userTypes (typename) value ('STUDENT');
insert into userTypes (typename) value ('FACULTY');
insert into userTypes (typename) value ('ADMIN_PORTAL');
insert into userTypes (typename) value ('ADMIN_MAPS');
insert into userTypes (typename) value ('ADMIN_BUDDY');
insert into userTypes (typename) value ('ADMIN_CLASS');
insert into userTypes (typename) value ('ADMIN_GYM');
insert into userTypes (typename) value ('GOD');

insert into roles (rolename) value ('ROLE_GENERAL');
insert into roles (rolename) value ('ROLE_STUDENT');
insert into roles (rolename) value ('ROLE_FACULTY');
insert into roles (rolename) value ('ROLE_ADMIN');
insert into roles (rolename) value ('ROLE_ADMIN_PORTAL');
insert into roles (rolename) value ('ROLE_ADMIN_MAPS');
insert into roles (rolename) value ('ROLE_ADMIN_BUDDY');
insert into roles (rolename) value ('ROLE_ADMIN_CLASS');
insert into roles (rolename) value ('ROLE_ADMIN_GYM');
insert into roles (rolename) value ('ROLE_GOD');

insert into rolesPerType (typeid, roleid) value (1, 1);
insert into rolesPerType (typeid, roleid) value (2, 1);
insert into rolesPerType (typeid, roleid) value (2, 2);
insert into rolesPerType (typeid, roleid) value (3, 1);
insert into rolesPerType (typeid, roleid) value (3, 3);
insert into rolesPerType (typeid, roleid) value (4, 1);
insert into rolesPerType (typeid, roleid) value (4, 4);
insert into rolesPerType (typeid, roleid) value (4, 5);
insert into rolesPerType (typeid, roleid) value (5, 1);
insert into rolesPerType (typeid, roleid) value (5, 4);
insert into rolesPerType (typeid, roleid) value (5, 6);
insert into rolesPerType (typeid, roleid) value (6, 1);
insert into rolesPerType (typeid, roleid) value (6, 4);
insert into rolesPerType (typeid, roleid) value (6, 7);
insert into rolesPerType (typeid, roleid) value (7, 1);
insert into rolesPerType (typeid, roleid) value (7, 4);
insert into rolesPerType (typeid, roleid) value (7, 8);
insert into rolesPerType (typeid, roleid) value (8, 1);
insert into rolesPerType (typeid, roleid) value (8, 4);
insert into rolesPerType (typeid, roleid) value (8, 9);
insert into rolesPerType (typeid, roleid) value (9, 1);
insert into rolesPerType (typeid, roleid) value (9, 4);
insert into rolesPerType (typeid, roleid) value (9, 5);
insert into rolesPerType (typeid, roleid) value (9, 6);
insert into rolesPerType (typeid, roleid) value (9, 7);
insert into rolesPerType (typeid, roleid) value (9, 8);
insert into rolesPerType (typeid, roleid) value (9, 9);
insert into rolesPerType (typeid, roleid) value (9, 10);

create table colleges(
	collegeid int not null auto_increment,
	collegename varchar(50) not null,
	primary key (collegeid)
)ENGINE = InnoDB;
insert into colleges (collegename) value ('College of Arts and Letters');
insert into colleges (collegename) value ('College of Fine Arts');
insert into colleges (collegename) value ('College of Human Kinetics');
insert into colleges (collegename) value ('College of Mass Communications');
insert into colleges (collegename) value ('College of Music');
insert into colleges (collegename) value ('Asian Center');
insert into colleges (collegename) value ('College of Education');
insert into colleges (collegename) value ('Institute of Islamic Studies');
insert into colleges (collegename) value ('College of Law');
insert into colleges (collegename) value ('College of Social Work and Community Development');
insert into colleges (collegename) value ('College of Social Sciences and Philosophy');
insert into colleges (collegename) value ('Asian Institute of Tourism');
insert into colleges (collegename) value ('College of Business Administration');
insert into colleges (collegename) value ('School of Economics');
insert into colleges (collegename) value ('School of Labor and Industrial Relations');
insert into colleges (collegename) value ('School of Urban and Regional Planning');
insert into colleges (collegename) value ('National College of Public Administration & Governance');
insert into colleges (collegename) value ('Technology Management Center');
insert into colleges (collegename) value ('College of Architecture');
insert into colleges (collegename) value ('College of Engineering');
insert into colleges (collegename) value ('College of Home Economics');
insert into colleges (collegename) value ('College of Science');
insert into colleges (collegename) value ('Statistical Center');
insert into colleges (collegename) value ('School of Library and Information Studies');
insert into colleges (collegename) value ('Archaeological Studies Program');


grant all privileges on uportaldb.colleges to 'java'@'localhost' with grant option;

create table departments(
	collegeid int not null,
	deptid int not null auto_increment,
	deptname varchar(50),
	primary key (deptid),
	constraint fk_collegeid foreign key (collegeid)
	references colleges(collegeid)
)ENGINE = InnoDB;

insert into departments (collegeid, deptname) values 
(19, ''),
(13, ''),
(14, ''),
(9, ''),
(24, ''),
(10, ''),
(23, ''),
(12, ''),
(25, ''),
(6, ''),
(8, ''),
(3, ''),
(15, ''),
(16, ''),
(18, ''),
(1,'Department of Art Studies'),
(1,'Department of English and Comparative Literature'),
(1,'Department of European Languages'),
(1,'Department of Filipino and Philippine Literature'),
(1,'Department of Speech Communication and Theater Arts'),
(1,'Institute of Creative Writing'),
(7,'Division of Curriculum and Instruction'),
(7,'Division of Educational Leadership and Professional Services'),
(20,'Department of Chemical Engineering'),
(20,'Institute of Civil Engineering'),
(20,'Department of Computer Science'),
(20,'Electrical and Electronics Engineering Institute'),
(20,'Department of Engineering Sciences'),
(20,'Department of Geodetic Engineering'),
(20,'Department of Industrial Engineering and Operations Research'),
(20,'Department of Mechanical Engineering'),
(20,'Department of Mining, Metallurgical and Materials Engineering'),
(2,'Department of Studio Arts'),
(2,'Department of Visual Communication'),
(2,'Department of Art Theory'),
(21,'Department of Food Science and Nutrition'),
(21,'Department of Hotel, Restaurant and Institution Management'),
(21,'Department of Clothing, Textiles and Interior Design'),
(21,'Department of Family Life and Child Development'),
(21,'Home Economics Education Department'),
(4,'Department of Broadcast Communication'),
(4,'Department of Communication Research'),
(4,'Department of Film'),
(4,'Department of Journalism'),
(4,'Graduate Studies'),
(5,'Voice / Theater and Dance Department'),
(5,'Keyboard Department'),
(5,'Strings Department'),
(5,'Winds & Percussion Department'),
(5,'Music Education Department'),
(5,'Musicology Department'),
(5,'Conducting and Choral Ensemble Department'),
(5,'Composition and Theory Department'),
(17,'Center for Public Administration and Governance Education'),
(17,'Center for Policy and Executive Development'),
(17,'Center for Local and Regional Governance'),
(17,'Center for Leadership, Citizenship and Democracy'),
(22,'Institute of Biology'),
(22,'Institute of Chemistry'),
(22,'Institute of Environmental Science and Meteorology'),
(22,'National Institute of Geological Sciences'),
(22,'National Institute of Physics'),
(22,'Marine Science Institute'),
(22,'Institute of Mathematics'),
(22,'National Institute of Molecular Biology & Biotechnology'),
(22,'Natural Sciences Research Institute'),
(22,'Materials Science and Engineering Program'),
(22,'Science and Society Program'),
(22,'Computational Science Research Center'),
(11,'Department of Anthropology'),
(11,'Department of Geography'),
(11,'Department of History'),
(11,'Department of Linguistics'),
(11,'Department of Philosophy'),
(11,'Department of Political Science'),
(11,'Department of Psychology'),
(11,'Department of Sociology');

grant all privileges on uportaldb.departments to 'java'@'localhost' with grant option;

create table courses(
	deptid int not null,
	courseid int not null auto_increment,
	coursename varchar(50) not null,
	primary key (courseid),
	constraint fk_deptid foreign key (deptid)
	references departments(deptid)
)ENGINE = InnoDB;

insert into courses (deptid, coursename) values
(1,'BS Architecture'),
(1,'B Landscape Architecture'),
(1,'M Architecture'),
(1,'M Tropical Landscape Architecture'),
(2,'BS Business Administration'),
(2,'BS Business Administration and Accountancy'),
(2, 'M Business Administration'),
(2, 'MS Finance'),
(2, 'Ph.D Business Administration'),
(3,'BS Economics'),
(3,'BS Business Economics'),
(3,'MA Economics'),
(3,'M Development Economics'),
(3,'Ph.D Economics'),
(4,'B Laws'),
(5,'Diploma in Librarianship'),
(5,'B Library and Information Science'),
(5,'M Library and Information Science'),
(6,'BS Community Development'),
(6,'BS Social Work'),
(6,'MS Community Development'),
(6,'MS Social Work'),
(6,'Diploma in Community Development'),
(6,'Diploma in Social Work'),
(7,'BS Statistics'),
(7,'M Statistics'),
(7,'MS Statistics'),
(7,'Ph.D Statistics'),
(8,'BS Tourism'),
(9,'Diploma in Archaeology'),
(9,'MS Archaeology'),
(9,'MA Archaeology'),
(9,'Ph.D Archaeology'),
(10,'MA Asian Studies'),
(10,'M Asian Studies'),
(10,'MA Philippne Studies'),
(10,'M Philippne Studies'),
(10,'Ph.D Philippne Studies'),
(11,'MA Islamic Studies'),
(12, 'Certificate in Sports'),
(12, 'Bachelor of Physical Education'),
(12, 'Bachelor of Sports Science'),
(12, 'Diploma in Physical Education'),
(12, 'M Physical Education'),
(12, 'MS Physical Education'),
(13, 'Diploma in Industrial Relations'),
(13, 'M Industrial Relations'),
(14, 'Diploma in Urban and Regional Planning'),
(14, 'MA Urban and Regional Planning'),
(14, 'Ph.D Urban and Regional Planning'),
(15, 'Diploma in Technology Management'),
(15, 'M Technology Management'),
(16,'BA Art Studies'),
(16, 'MA Art Studies'),
(17,'BA English Studies'),
(17,'BA Comparative Literature'),
(17,'BA Creative Writing'),
(17,'MA English Studies'),
(17,'MA Comparative Literature'),
(17,'MA Creative Writing'),
(17,'Ph.D English Studies'),
(17,'Ph.D Comparative Literature'),
(17,'Ph.D Creative Writing'),
(18,'BA European Languages'),
(18,'MA Spanish'),
(18,'MA French'),
(18,'MA German'),
(18,'Ph.D Hispanic Literature'),
(19,'Sertipiko sa Malikhaing Pagsulat sa Filipino'),
(19,'BA Filipino'),
(19,'BA Araling Pilipino'),
(19,'BA Malikhaing Pagsulat'),
(19,'MA Araling Pilipino'),
(19,'MA Filipino'),
(19,'Ph.D Filipino'),
(20,'Certificate in Theater Arts'),
(20,'BA Speech Communication'),
(20,'BA Theater Arts'),
(20, 'MA Speech Communication'),
(20,'MA Theater Arts'),
(21, ''),
(22,'B Elementary Education'),
(22,'B Secondary Education'),
(23,'MA Education'),
(23,'Ph.D Education'),
(24,'BS Chemical Engineering'),
(24,'MS Chemical Engineering'),
(24,'Ph.D Chemical Engineering'),
(24,'E.D Chemical'),
(25,'BS Civil Engineering'),
(25,'MS Civil Engineering'),
(26,'BS Computer Science'),
(26,'MS Computer Science'),
(28,'Diploma in Engineering'),
(27,'BS Computer Engineering'),
(27,'BS Electrical Engineering'),
(27,'BS Electronics and Communications Engineering'),
(29,'BS Geodetic Engineering'),
(30,'BS Industrial Engineering'),
(31,'BS Mechanical Engineering'),
(32,'BS Mining Engineering'),
(32,'BS Metallurgical Engineering'),
(32,'BS Materials Engineering'),
(33,'BFA Painting'),
(33,'BFA Sculpture'),
(34,'BFA Industrial Design'),
(34,'BFA Visual Communication'),
(35,'BFA Art Education'),
(35,'BFA Art History'),
(36,'BS Food Technology'),
(36,'BS Community Nutrition'),
(37,'BS Hotel & Restaurant Administration'),
(38,'BS Clothing Technology'),
(38,'BS Interior Design'),
(39,'BS Family Life and Child Development'),
(40,'BS Home Economics'),
(41,'BA Broadcast Communication'),
(42,'BA Communication Research'),
(43,'BA Communication, Major in Film and Audio-Visual Communication'),
(44,'BA Journalism'),
(45,'MA Communication'),
(45,'MA Media Studies'),
(46,'BM Dance'),
(46,'BM Voice'),
(47,'BM Keyboard'),
(48,'BM Strings'),
(49,'BM Winds'),
(49,'BM Percussion'),
(50,'BM Music Education'),
(51,'BM Musicology'),
(52,'BM Choral/Orchestral Conducting'),
(53,'BM Composition'),
(54,'BA Public Administration'),
(55,'MPA Public Policy and Program Administration'),
(56,'MPA Local Government and Regional Administration'),
(57,'MPA Organization Studies, Public Enterprise Management'),
(58,'BS Biology'),
(59,'BS Chemistry'),
(60,'Diploma in Environmental Science'),
(61,'BS Geology'),
(62,'BS Physics'),
(63,'BS Applied Physics'),
(64,'BS Mathematics'),
(65,'BS Molecular Biology and Biotechnology'),
(66,''),
(67,''),
(68,''),
(69,''),
(70,'BA Anthropology'),
(71,'BS Geography'),
(72,'BA History'),
(73,'BA Linguistics'),
(74,'BA Philosophy'),
(75,'BA Political Science'),
(76,'BA Psychology'),
(76,'BS Psychology'),
(77,'BA Sociology');



grant all privileges on uportaldb.courses to 'java'@'localhost' with grant option;

create table hotlines(
	id int not null auto_increment,
	name varchar(50) not null,
	info varchar(100) not null,
	primary key (id));

insert into hotlines (name, info) value ('UP Diliman Police', '9283615*9818500 loc 4008 (Radio Room)*113 (Helpdesk)');
insert into hotlines (name, info) value ('University Health Service', '9818500 loc 111');
insert into hotlines (name, info) value ('Bureau of Fire Protection', '928-8363 (Quezon City Hall)*924-1922*441-8279 (Libis)*492-7576 (Loyola Heights)*931-9894 (New Era)');
insert into hotlines (name, info) value ('Bomb Squad', '436-0948*924-3101');
insert into hotlines (name, info) value ('Philippne National Red Cross Quezon City Chapter', '920-3672*433-6568 (Blood Bank)*433-2151 to 52*434-3751');
insert into hotlines (name, info) value ('Meralco', '631-1111*162-11');
insert into hotlines (name, info) value ('PLDT', '173*171');

grant all privileges on uportaldb.hotlines to 'java'@'localhost' with grant option;

create table hitcounter(
page varchar(50) not null,
views int default 0,
primary key(page)
)ENGINE = InnoDB;

insert into hitcounter(page,views) value ('homepage', 0);

grant all privileges on uportaldb.hitcounter to 'java'@'localhost' with grant option;