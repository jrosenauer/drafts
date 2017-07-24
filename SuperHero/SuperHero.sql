DROP DATABASE IF EXISTS SuperHero;

CREATE DATABASE SuperHero;

CREATE TABLE SuperHero.Location (
LocationID INT NOT NULL AUTO_INCREMENT,
LocationName VARCHAR(140) NOT NULL,
LocationDescription VARCHAR(150) NOT NULL,
LocationAddress VARCHAR(150) NOT NULL,
LocationLongitude DECIMAL(20,10) NOT NULL,
LocationLatitude DECIMAL(20,10) NOT NULL,
PRIMARY KEY (LocationID));

CREATE TABLE SuperHero.Organization (
OrganizationID INT NOT NULL AUTO_INCREMENT,
OrganizationName VARCHAR(30) NOT NULL,
OrganizationDescription VARCHAR(150) NOT NULL,
OrganizationAddress VARCHAR(140) NOT NULL,
OrganizationPhone VARCHAR(10) NOT NULL,
OrganizationEmail VARCHAR(50) NOT NULL,
PRIMARY KEY (OrganizationID));

CREATE TABLE SuperHero.SuperHero (
SuperID INT NOT NULL AUTO_INCREMENT,
SuperName VARCHAR(40) NOT NULL,
SuperDescription VARCHAR(1500) NOT NULL,
SuperPower VARCHAR(40) NOT NULL,
PRIMARY KEY (SuperID));

CREATE TABLE SuperHero.SuperOrganization (
SuperID INT,
OrganizationID INT,
PRIMARY KEY (SuperID, OrganizationID),

constraint fk_SuperOrganization_SuperHero
FOREIGN KEY (SuperID)
references SuperHero.SuperHero (SuperID)
on delete cascade on update no action,

constraint fk_SuperOrganization_Organization
FOREIGN KEY (OrganizationID)
references SuperHero.Organization (OrganizationID)
on delete cascade on update no action);

CREATE TABLE SuperHero.Sighting (
SightingID INT NOT NULL AUTO_INCREMENT,
SightingDate DATETIME NOT NULL,
LocationID INT,
PRIMARY KEY (SightingID),

constraint  fk_Sighting_Location
FOREIGN KEY (LocationID)
references SuperHero.Location (LocationID)
on delete cascade on update no action);

CREATE TABLE SuperHero.SuperSighting (
SuperID INT,
SightingID INT,
PRIMARY KEY (SuperID, SightingID),

constraint fk_SuperSighting_SuperHero
FOREIGN KEY (SuperID)
references SuperHero.SuperHero (SuperID)
on delete cascade on update no action,

constraint fk_SuperSighting_Sighting
FOREIGN KEY (SightingID)
references SuperHero.Sighting (SightingID)
on delete cascade on update no action);