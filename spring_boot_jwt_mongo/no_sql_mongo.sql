=> mongod --directoryperdb --dbpath C:\mongodb\data --logpath C:\mongodb\log\mongo.log --logappend --rest --install
=>mongod

-- import data from json
mongoimport --db test --collection restaurants --drop --file ~/downloads/primer-dataset.json
---MAC
=>mongod --directoryperdb --dbpath /Users/tanmoydas/Softwares/mongodb/data/db/ --logpath /Users/tanmoydas/Softwares/mongodb/log/mongo.log --logappend

--this above command is not working in mac- so for mac use the below code to run mongod instance
sudo ./mongod --dbpath /Users/tanmoydas/Softwares/mongodb/data/db/ --logpath /Users/tanmoydas/Softwares/mongodb/log/mongo.log --logappend

=> ./mongo

-- list of dbs
show dbs;

-- connect to specific db, if doesn't exists will create new one
use homeutility;

--create a user
db.createUser( { user: "dast",
                 pwd: "mongodb",
                 roles: [ "dbAdmin", "readWrite"] },
               { w: "majority" , wtimeout: 5000 } );


--create collection (table)

 db.createCollection('cars');
show collections;

--- insert record
db.cars.insert({id: 0, make: "ford", model:"i20", description: "i20 -magna", year:2017})
db.cars.insert({id: 1, make: "hundai", model:"i10", description: "i10 -grand", year:2016}) -- single record
db.cars.insert([{id: 2, make: "maruti", model:"swift", description: "swift-desire", year:2015}, {}]); -- for multiple record
db.cars.insert({id: 1, make: "tata", model:"tiago", description: "tiago-seadan", year:2016, fuel:"petrol"})


-- select record from collection
 db.cars.find();
 db.cars.find({make: "hundai"});

 db.cars.find({$or:[{make: "hundai"}, {make: "maruti"}]});
 db.cars.find().pretty();
  db.cars.find({year:{$gt:2000}}); -- $gt $lt $gte $lte
 db.cars.find().count();
 db.cars.find().limit(2);

 db.cars.find().forEach(function(car){print("Car model :"+car.model)});

 -- update collection
 db.cars.update({id:0}, {make:"Hundai"});
 -- add extra attribute keeping previous one
  db.cars.update({id:2}, {$set:{fuel:"petrol"}});
-- increment value
db.cars.update({id:0}, {$inc:{year:-10}});
-- remove field attribute
db.cars.update({id:2}, {$unset:{fuel:1}});

-- upsert - if no matched item found to update it will insert a new record
db.cars.update({id:5}, {make:"Hundai"}, {upsert:true});

--rename attribute name

db.cars.update({id:5}, {$rename:{"gender":"sex"}});
--remove record
db.cars.remove({id:0});
db.cars.remove({id:0},{justone:"true"});
---------------------------------------
db.journals.insert({journal_id:NumberInt(2177), title: "Some Issues Concerning Future Irish Growth", author:"Frank Barry", year:NumberInt(2008), volume:NumberInt(56), number:NumberInt(1), file_name: "56b1_Some_Issues_Concerning_Future_Irish_Growth.pdf", season: "SPRING", keyWords:""});


db.createCollection('journals', {
  capped:false,
  autoIndexId:true,

})

db.journals.remove({id:2177});


db.createCollection('task_list', {
  capped:false,
  autoIndexId:true,

});
db.task_list.insert({
    _id:getTaskNextSequenceValue("taskListId"),
    task_name:"Gathering Requirement",
    task_description:"Requirement Gathering",
    task_priority:"MEDIUM",
    task_status:"ACTIVE",
    task_start_time: new Date(),
    task_end_time: null,
    task_archived:false
    });

  db.task_list.insert({
      _id:getTaskNextSequenceValue("taskListId"),
      task_name:"Maintanence",
      task_description:"Maintanence",
      task_priority:"LOW",
      task_status:"ACTIVE",
      task_start_time: new Date(),
      task_end_time: null,
      task_archived:false
      });
db.task_list.update({_id:1}, {$set:{creator_id:"mukers"}});
----My Sql ----------
create database taskmanager;
use taskmanager;
create table task_list(task_id int not null auto_increment, task_name varchar(100) not null,
   task_description text,task_priority varchar(20),task_status varchar(20),
   task_start_time datetime not null default CURRENT_TIMESTAMP,
   task_end_time datetime not null default CURRENT_TIMESTAMP,
   task_archived bool default false,primary key(task_id));
insert into task_list values(1,'Gathering Requirement','Requirement Gathering','MEDIUM','ACTIVE',curtime(),curtime() + INTERVAL 3 HOUR,0);
insert into task_list values(2,'Application Designing','Application Designing','MEDIUM','ACTIVE',curtime(),curtime() + INTERVAL 2 HOUR,0);
insert into task_list values(3,'Implementation','Implementation','MEDIUM','ACTIVE',curtime(),curtime() + INTERVAL 3 HOUR,0);
insert into task_list values(4,'Unit Testing','Unit Testing','LOW','ACTIVE',curtime(),curtime() + INTERVAL 4 HOUR,0);
insert into task_list values(5,'Maintanence','Maintanence','LOW','ACTIVE',curtime(),curtime() + INTERVAL 5 HOUR,0);
select * from task_list;
-------------------------
-- Create a sequencr column in mongodb
--https://www.tutorialspoint.com/mongodb/mongodb_autoincrement_sequence.htm

--http://www.programming-free.com/2014/07/spring-data-rest-with-angularjs-crud.html
----------------
db.createCollection("task_list_counters");
db.task_list_counters.insert({_id:"taskListId",sequence_value:0});

function getTaskNextSequenceValue(sequenceName){

   var sequenceDocument = db.task_list_counters.findAndModify({
      query:{_id: sequenceName },
      update: {$inc:{sequence_value:1}},
      new:true
   });

   return sequenceDocument.sequence_value;
};

db.createCollection('jwt_users');

db.jwt_users.insert({ user_id: "dast",
                 passwd: "mongodb",
                 user_fname: "Tanmoy",
                 user_lname: "Das",
                 active_flag: "Y",
                 roles: [ "dbAdmin", "readWrite"],
                 create_time: new Date(), });
