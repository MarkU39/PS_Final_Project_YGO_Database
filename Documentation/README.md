# YGO Database

An application built to document a collection of Yu-Gi-Oh! trading cards. This app includes a tracker for collections, deck lists, and a want list, as well as search features that will allow you to query your collection

### Prerequisites

This app uses the following software:

- EclipseLink 2.5.2
- Java EE
- Spring MVC 5.2.8
- MariaDB/MySQL
- Maven
- JUnit 4
- Javax Validation 2.0.0
- JSTL 1.2

## Running the tests

To run the JUnit tests, simply run the test suites using Eclipse's "Run as JUnit Test" feature.

## Deployment

This section is still in development. 

This project is intended to be run on a local server; in my deployment, I run the project on an Apache Tomcat server and interact with it through my browser. With the proper dependencies installed, this project should be simply download-and-run, as the needed dependencies are included in pom.xml.

## Authors

Mark Uszacki


## Other information
### User stories
##### Collection Storage Stories
As a gamer, I want to have a static store of the cards in my collection so that I can keep track of the cards I have.
As a gamer, I want to be able to add cards to that static store so that I can maintain up-to-date records of the cards I’ve collected.
As a trader, I want to be able to remove cards from my collection because sometimes I will sell or trade my cards and I would like my records to reflect this.
As a gamer, I want to be able to store multiple types of cards so that I can differentiate between them.
As a gamer, I want to be able to keep records of card name, set code, rarity, printing, and quantity of cards so that I can have access to all the information I might need about my collection.

##### Want List Stories
As a trader, I want to keep a want list so that I can remember which cards I would like to acquire in trade if given the chance.
As a gamer, I want to add and remove cards from this list at will because the cards I want will change as the game and my collection evolves (for instance, if I acquire a card or if a card gets banned).
As a trader, I want to be able to view my want list in a clear format so that I can identify absences or out-of-date entries.

##### Search Functionality
As a trader, I would like to be able to query my collection so that I can quickly identify whether or not I have a card.

##### Deck Functionality
As a gamer, I would like to be able to track my deck lists so that I can quickly assemble documentation for tournaments or revert to older decks.
As a gamer, I would like to be able to add and remove cards from deck lists so that I can keep decks up-to-date.

### Technical challenges
Part of the fun of this project for me is that it required me to learn new technologies that I previously hadn't worked with. The biggest technical challenge I had was and is working out exactly how the entities should relate to one another, and preserving those relationships properly through handlers and OOP principles.

## Notes
- This project was built as part of the Per Scholas Java Developer course sponsored by Barclays.
- This is a fan hobby project unaffiliated with Konami or the Yu-Gi-Oh! TCG.

### GitHub Location 
This project is hosted on GitHub at:
https://github.com/MarkU39/PS_Final_Project_YGO_Database
