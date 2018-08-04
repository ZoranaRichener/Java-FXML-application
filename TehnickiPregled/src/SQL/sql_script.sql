/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     7/29/2018 4:31:30 PM                         */
/*==============================================================*/


drop table if exists GALERIJA;

drop table if exists KLIJENT;

drop table if exists TEHNICKI_PREGLED;

drop table if exists VOZILO;

/*==============================================================*/
/* Table: GALERIJA                                              */
/*==============================================================*/
create table GALERIJA
(
   GALERIJA_ID          int  NOT NULL AUTO_INCREMENT ,
   TEHNICKI_PREGLED_ID  int,
   SLIKA                longblob not null,
   primary key (GALERIJA_ID)
);

/*==============================================================*/
/* Table: KLIJENT                                               */
/*==============================================================*/
create table KLIJENT
(
   KLIJENTI_ID          int  NOT NULL AUTO_INCREMENT ,
   VOZILO_ID            int,
   IME                  varchar(25) not null,
   PREZIME              varchar(25) not null,
   JMBG                 varchar(25) not null,
   BROJ_LICNE_KARTE     varchar(25) not null,
   ADRESA               varchar(25),
   OPSTINA              varchar(25),
   BROJ_MOBILNOG        varchar(25) not null,
   primary key (KLIJENTI_ID)
);

/*==============================================================*/
/* Table: TEHNICKI_PREGLED                                      */
/*==============================================================*/
create table TEHNICKI_PREGLED
(
   TEHNICKI_PREGLED_ID  int  NOT NULL AUTO_INCREMENT ,
   GALERIJA_ID          int,
   VOZILO_ID            int,
   NAZIV_FIRME          varchar(25) not null,
   SEDISTE_FIRME        varchar(25) not null,
   SIFRA_TEHNICKOG_PREGLEDA varchar(6) not null,
   KONTROLOR_1          varchar(30) not null,
   KONTROLOR_2          varchar(30) not null,
   USLOVI_ZA_VRSENJE_PREGLEDA varchar(15) not null,
   MESTO_VRSENJA_PREGLEDA varchar(25) not null,
   VRSTA_PREGLEDA       varchar(15) not null,
   REDNI_BROJ           varchar(3) not null,
   ID_BROJ              varchar(14) not null,
   VRSTA_VOZILA         varchar(15) not null,
   ISPRAVNOST_VOZILA    varchar(10) not null,
   KONTROLNI_BROJ       varchar(10),
   DATUM_PREGLEDA       date not null,
   POCETAK_PREGLEDA     varchar(15) not null,
   ZAVRSETAK_PREGLEDA   varchar(15) not null,
   PODACI_O_NEISPRAVNOSTI varchar(256),
   primary key (TEHNICKI_PREGLED_ID)
);

/*==============================================================*/
/* Table: VOZILO                                                */
/*==============================================================*/
create table VOZILO
(
   VOZILO_ID            int  NOT NULL AUTO_INCREMENT ,
   TEHNICKI_PREGLED_ID  int,
   KLIJENTI_ID          int,
   MARKA_VOZILA         varchar(25) not null,
   MODLE_VOZILA         varchar(25) not null,
   TIP_VOZILA           varchar(25) not null,
   BROJ_SASIJE          varchar(17) not null,
   BROJ_MOTORA          varchar(25) not null,
   SNAGA_MOTORA         varchar(5) not null,
   ZAPREMAINA_MOTORA    varchar(4) not null,
   GODINA_PROIZVODNJE   varchar(4) not null,
   ZEMLJA_PROIZVODNJE   varchar(15),
   DOZVOLJENA_NOSIVOST  varchar(4) not null,
   MASA_PRAZNOG_VOZILA  varchar(4) not null,
   NAJVECA_DOZVOLJENA_MASA varchar(4) not null,
   SIFRA_POSLEDNJEG_TEHNICKOG varchar(10) not null,
   DATUM_POSLEDNJEG_TEHNICKOG date not null,
   DATUM_ISTEKA_SAOBRACAJNE date not null,
   BROJ_MESTA_U_VOZILU  varchar(1) not null,
   STAJANJE             varchar(2) not null,
   OSNOVNA_NAMENA       varchar(10) not null,
   BOJA_VOZILA          varchar(25) not null,
   VRSTA_BOJA           varchar(25) not null,
   BROJ_OSOVINA         varchar(1) not null,
   VRSTA_GORIVA         varchar(25) not null,
   PREDJENI_PUT         varchar(6) not null,
   KUKA                 varchar(2) not null,
   DATUM_PRVE_REGISTRACIJE date not null,
   DUZINA_VOZILA        varchar(5),
   SIRINA_VOZILA        varchar(5),
   VISINA_VOZILA        varchar(5),
   primary key (VOZILO_ID)
);

alter table GALERIJA add constraint FK_RELATIONSHIP_6 foreign key (TEHNICKI_PREGLED_ID)
      references TEHNICKI_PREGLED (TEHNICKI_PREGLED_ID) on delete restrict on update restrict;

alter table KLIJENT add constraint FK_RELATIONSHIP_1 foreign key (VOZILO_ID)
      references VOZILO (VOZILO_ID) on delete restrict on update restrict;

alter table TEHNICKI_PREGLED add constraint FK_RELATIONSHIP_4 foreign key (VOZILO_ID)
      references VOZILO (VOZILO_ID) on delete restrict on update restrict;

alter table TEHNICKI_PREGLED add constraint FK_RELATIONSHIP_5 foreign key (GALERIJA_ID)
      references GALERIJA (GALERIJA_ID) on delete restrict on update restrict;

alter table VOZILO add constraint FK_RELATIONSHIP_2 foreign key (KLIJENTI_ID)
      references KLIJENT (KLIJENTI_ID) on delete restrict on update restrict;

alter table VOZILO add constraint FK_RELATIONSHIP_3 foreign key (TEHNICKI_PREGLED_ID)
      references TEHNICKI_PREGLED (TEHNICKI_PREGLED_ID) on delete restrict on update restrict;

