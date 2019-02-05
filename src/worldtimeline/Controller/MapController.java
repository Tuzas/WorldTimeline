/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldtimeline.Controller;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import worldtimeline.Model.ButtonColor;
import worldtimeline.Model.HistoryButton;

/**
 *
 * @author Alex
 */
public class MapController {

    private final ArrayList<HistoryButton> buttons = new ArrayList<>();

    @FXML
    private Slider yearsSlider;

    @FXML
    private AnchorPane imagePane;

    @FXML
    private TextField currentDateRange;

    public void initialize() {
        populateButtons();
        yearsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            imagePane.getChildren().clear();
            currentDateRange.setText(newValue.intValue() + "-" + (newValue.intValue() + 25));
            for (HistoryButton button : buttons) {
                if (button.getDateTo() >= newValue.intValue() && button.getDateFrom() <= newValue.intValue() + 25) {
                    imagePane.getChildren().add(button);
                }
            }
        });

    }

    //england 120, 521
    //canton 960, 250
    private void populateButtons() {
        HistoryButton corsairBigPictureButton = new HistoryButton(1500, 1830, 600, 200, ButtonColor.CORSAIRS);
        corsairBigPictureButton.setStyle(corsairBigPictureButton.buttonNotClicked());
        corsairBigPictureButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Corsairs: Big Picture");
                stage.setScene(new Scene(parent));
                controller.setTitle("Corsairs: Big Picture (1500-1830)");
                controller.addText("ID Terms\n"
                        + "    Yusuf Rais - Muslim Convert Corsair\n"
                        + "    Privateers - Name for pirates with letter of marque\n"
                        + "    Articles of Capitulation - Trade agreement between Ottomans and Europeans whose stipulations included:\n"
                        + "         -Borders were to be respected\n"
                        + "         -Europeans in Ottoman region could practice their religion\n"
                        + "         -Ottoman authorities would punish corsairs who attacked European ships and refund the value of the goods taken from them.\n"
                        + "    Letter of Marque - Pirate license\n"
                        + "    Barbarossa Brothers - Famous Muslim corsairs\n"
                        + "    Knights of the Order of St. John Hospitaller - Christian religious order that acted as privateers out of Malta\n");
                controller.addHeader("Corsair Overview");
                controller.addText("Corsairs were legal pirates who were sponsored by a country through a letter of marque. "
                        + "This gave them special privileges to legally attack ships that were outlined in the letter of marque. "
                        + "Corsairs were usually employed by one government against other governments. Corsairs were also partitioned along "
                        + "religious lines of Muslim and Christian corsairs. However, it was not uncommon for religious enemies "
                        + "to unite in order to fight political enemies. Corsairing dissipated following France's capture of Algiers in 1830.");
                controller.addImage("/worldtimeline/View/corsair1.jpg");
                controller.addImage("/worldtimeline/View/corsair2.jpg");
                controller.addImage("/worldtimeline/View/corsair3.jpg");
                stage.show();
                corsairBigPictureButton.setStyle(corsairBigPictureButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(corsairBigPictureButton);

        HistoryButton yusufRaisButton = new HistoryButton(1553, 1622, 575, 210, ButtonColor.CORSAIRS);
        yusufRaisButton.setStyle(yusufRaisButton.buttonNotClicked());
        yusufRaisButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Yusuf Rais");
                stage.setScene(new Scene(parent));
                controller.setTitle("Yusuf Rais (c. 1553 - 1622)");
                controller.addText("-Originally named John Ward \n"
                        + "-Worked as a Muslim corsair \n"
                        + "-Operated out of Tunis \n"
                        + "-Converted to Islam and changed name to Yusuf Rais \n"
                        + "-Attacked the Soderina in April 1607 \n");
                controller.setImageWidth(0);
                stage.show();
                yusufRaisButton.setStyle(yusufRaisButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(yusufRaisButton);

        HistoryButton corsairBarbarossaButton = new HistoryButton(1478, 1546, 540, 190, ButtonColor.CORSAIRS);
        corsairBarbarossaButton.setStyle(corsairBarbarossaButton.buttonNotClicked());
        corsairBarbarossaButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Barbarossa Brothers");
                stage.setScene(new Scene(parent));
                controller.setTitle("Barbarossa Brothers (c. 1478 - 1545)");
                controller.addText("The Barbarossa brothers were born on the island of Lesbos in the Ottoman Empire. They were responsibly for founding the legacy of corsairing in the early 1500's."
                        + " The older brother, Oruc, was captured by the Knights of St. John and taken prisoner where he worked for 3 years as a galley slave. Eventually, his ransom was paid by his father, "
                        + "after which Oruc worked as a corsair with his younger brother Hayreddin in Tunis. By 1510 they had a reputation for attacking Christian knights. In 1516 Oruc took Algiers, but lost an arm."
                        + " In 1518 he was killed in battle while fighting the Spanish. Hayreddin took charge of Algiers following Oruc's death. He promised the control of Algiers to the Ottoman Empire if the sultan "
                        + "would assist them against the Spanish. Hayreddin ended up taking a territory for the Sultan and was proclaimed chief governfor of North Africa and Admiral of the Ottoman navy under the sultan. "
                        + "Should be noted Hayreddin is also known as Khayr ad-Din. He retired in 1545 in Constantinople where he died in 1546.");
                controller.addImage("/worldtimeline/View/barbarossa1.jpg");
                stage.show();
                corsairBarbarossaButton.setStyle(corsairBarbarossaButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(corsairBarbarossaButton);

        HistoryButton corsairKOSTJHButton = new HistoryButton(1530, 1798, 575, 192, ButtonColor.CORSAIRS);
        corsairKOSTJHButton.setStyle(corsairKOSTJHButton.buttonNotClicked());
        corsairKOSTJHButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Knights of St. John Hospitaller");
                stage.setScene(new Scene(parent));
                controller.setTitle("Knights of St. John Hospitaller (1530 - 1798)");
                controller.addText("The Knights of St. John Hospitaller were founded in the 11th century following the first crusade for Jerusalem. Their initial mission was to care for the "
                        + "poor and the sick, as well as defend Christians from religious enemies. They acted as mercenaries and became wealthy. The order was given the island of Malta where they established a base"
                        + " in 1530. The knights offered maltese pirates privateer status, this did not mean the locals were given positions as knights in the order. It should be noted that some knights attacked Christian "
                        + "communitties, and there were records of at least one Maltese corsair being hanged for working with Muslims. The order sometimes turned a blind eye to piracy against Christian ships due to humanitarian reasons,"
                        + " such as the need for food. Ocassionally, they would pay back the owner of the ship that they pirated. The order eventually declined in power and was expelled from the island in 1798 following an invasion"
                        + " by Napoleon.");
                controller.addImage("/worldtimeline/View/kostj1.jpg");
                controller.addImage("/worldtimeline/View/kostj2.jpg");
                controller.addImage("/worldtimeline/View/kostj3.jpg");
                stage.show();
                corsairKOSTJHButton.setStyle(corsairKOSTJHButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(corsairKOSTJHButton);

        HistoryButton westernPiratesButton = new HistoryButton(1500, 1798, 250, 242, ButtonColor.WESTERN_PIRATES);
        westernPiratesButton.setStyle(westernPiratesButton.buttonNotClicked());
        westernPiratesButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Western Pirates");
                stage.setScene(new Scene(parent));
                controller.setTitle("Western Pirates: Big Picture (1500 - 1730)");
                controller.addHeader("Phase 1 : Age of Gentleman Pirates (1500-1600)");
                controller.addText("Characterized by short and long distance pirating (corsairs didn't do long distance)."
                        + " Most of the pirates involved were English or French and they primarily operated on the Atlantic coast."
                        + " Included privateers such as Francis Drake and Peg Leg (aka Francois Le Clerc)");
                controller.addHeader("Phase 2: Buccanneers (1630-1680)");
                controller.addText("Piracy was primarily based in Carribbean. The targets were mostly Spanish."
                        + " The pirates involved came from many nations and many different circumstances."
                        + " They consisted of privateers and pirates, but most were pirates. They had a somewhat egalitarian system of self governance.");
                controller.addHeader("Phase 3: Golden Age of Piracy (1680-1730)");
                controller.addText("Consisted of global piracy involving many nations with arguably egalitarian ship societies. The pirates were independent and thus faced strong crack downs from "
                        + "many governments. Included figures such as Henry Every, Blackbeard, and Mary Reed.");
                controller.addImage("/worldtimeline/View/westernPirates1.jpg");
                controller.addImage("/worldtimeline/View/westernPirates2.jpg");
                stage.show();
                westernPiratesButton.setStyle(westernPiratesButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(westernPiratesButton);

        HistoryButton francisDrakeButton = new HistoryButton(1542, 1596, 210, 310, ButtonColor.WESTERN_PIRATES);
        francisDrakeButton.setStyle(francisDrakeButton.buttonNotClicked());
        francisDrakeButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Francis Drake - Phase 1");
                stage.setScene(new Scene(parent));
                controller.setTitle("Francis Drake (1542 - 1596) - Phase 1");
                controller.addText("Francis Drake came from a poor farming family, he was sent to work on ships where he rose from the rank of ship boy to captain of a merchant ship."
                        + " Drake conducted legal and illegal trade with his cousin John Hawkins. Eventually he begins raiding ships and coastal settlements in the Americas, particularly those that belonged to the Spain. "
                        + "Drake becomes wealthy from his activities and becomes a privateer in 1577 under the command of Queen Elizabeth I. He is eventually knighted in 1580. From 1577 to 1580 he sails"
                        + " around the world. Drake's ventures included raiding Santiago and then burning the city after finding no treasure, attacking St. Augustine, rescuing the Roanoake colony, and being involved "
                        + "in the defeat of the Spanish armada. He was widely seen as Spanish villain and an English hero. He died in 1596 in Portobello, Panama while on a raid. The location marked on the map is Portobello");
                controller.addImage("/worldtimeline/View/francisDrake1.jpg");
                stage.show();
                francisDrakeButton.setStyle(francisDrakeButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(francisDrakeButton);

        HistoryButton henryMorganButton = new HistoryButton(1635, 1688, 225, 270, ButtonColor.WESTERN_PIRATES);
        henryMorganButton.setStyle(henryMorganButton.buttonNotClicked());
        henryMorganButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Henry Morgan - Phase 2");
                stage.setScene(new Scene(parent));
                controller.setTitle("Henry Morgan (c. 1635 - 1688) - Phase 2");
                controller.addText("Henry Morgan becomes involved in the Carribbean during the secret British 1654 expedition to Hispaniola. The result was a failure, and thus the "
                        + "expedition decided to occupy Jamaica instead. Jamaica was thus taken in 1655 and claimed by Britain. Jamaica was a buccaneer haven and had the support of the local "
                        + "governor until the king banned privateering, after which the governor as well as Morgan were arrested. Morgan was not imprisoned, instead he was given the task of "
                        + "exterminating the remaining pirates. By 1675 Morgan was knighted and the lieutenant governor of Jamaica. In 1683 he was removed from office for being drunk and giving away state secrets. "
                        + "He died in 1688 and was given a state funeral in Jamaica.");
                controller.addImage("/worldtimeline/View/henryMorgan1.jpg");
                stage.show();
                henryMorganButton.setStyle(henryMorganButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(henryMorganButton);

        HistoryButton phaseThreeButton = new HistoryButton(1680, 1730, 524, 125, ButtonColor.WESTERN_PIRATES);
        phaseThreeButton.setStyle(phaseThreeButton.buttonNotClicked());
        phaseThreeButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Golden Age of Piracy - Phase 3");
                stage.setScene(new Scene(parent));
                controller.setTitle("Golden Age of Piracy (1680 - 1730) - Phase 3");
                controller.addText("The Golden Age of Piracy saw a major backlash against pirates, with many nations choosing to work together to counter the pirate threat. The 1700 Piracy Law was passed "
                        + "in order to carry out expedient punishments to captured pirates. This time period saw pardons given to pirates who would turn themselves, as was the case in 1717, with the deadline of September 1718."
                        + "Pirates who were caught were tried under admirality law, collaborators were hung alongside pirates, there was no jury involved in the trials, and people were paid to act as informants. "
                        + "About 5000 pirates were stopped during this time period. The success of the anti-pirate endeavour was partly due to the hight amount of collaboration with locals where piracy was an issue.");
                controller.addImage("/worldtimeline/View/thirdPhase1.jpg");
                controller.addImage("/worldtimeline/View/thirdPhase2.jpg");
                stage.show();
                phaseThreeButton.setStyle(phaseThreeButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(phaseThreeButton);

        HistoryButton radioPiratesButton = new HistoryButton(1933, 1991, 521, 120, ButtonColor.PIRATE_RADIO);
        radioPiratesButton.setStyle(radioPiratesButton.buttonNotClicked());
        radioPiratesButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                controller.setTitle("Radio Pirates: Big Picture (1933-1991)");
                controller.addText("ID Terms\n"
                        + "     BBC - British Broadcasting Corporation\n"
                        + "     Radio Luxembourg - A precursor to radio pirates that began "
                        + "broadcasting in Luxembourg, targeting the British audience.\n"
                        + "     Radio Caroline - Radio pirate ship that began operation in 1964 and ended in 1991\n"
                        + "     Radio City - Pirate radio outpost operating out of Shivering Sands Army Fort, began operation in 1964 "
                        + "and closed on February 8th, 1967.\n"
                        + "     Ronan O’Rahilly - Created Radio Caroline\n"
                        + "     Marine Broadcasting Offenses Act - Marine act created in 1967 that tackled radio piracy through a territorial approach. "
                        + "This included measures such as prohibiting advertisements to be played on Pirate Radio stations and prohibiting any British assistance to pirate Radio Stations. "
                        + "Fines included up to 2 years in prison or 400£ fines.\n");
                controller.addHeader("Overview");
                controller.addText("Radio pirates grew out of the BBC's control of broadcasting in Britain. With the BBC's lack of advertising and lack of new music, "
                        + "radio pirates came in to fill the void. Radio pirates took advantage of broadcasting laws and operated outside of Britain, allowing them to play commercials and music"
                        + " from different countries while targeting a British audience. This began with Radio Luxembourg in 1933 and eventually moved on to ships and structures operating in "
                        + "international waters off the British and Irish coasts in 1964. Most ships were run out of business following the Marine Broadcasting Offenses Act of 1967. The last stations"
                        + " closed with the Broadcasting act of 1990 which allowed Britain to board and raid ships broadcasting in international waters.");
                controller.addImage("/worldtimeline/View/pirateRadio1.jpg");
                controller.addImage("/worldtimeline/View/pirateRadio2.jpg");
                controller.addImage("/worldtimeline/View/pirateRadio3.jpg");
                stage.show();
                radioPiratesButton.setStyle(radioPiratesButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(radioPiratesButton);

        HistoryButton radioCarolineButton = new HistoryButton(1964, 1991, 524, 130, ButtonColor.PIRATE_RADIO);
        radioCarolineButton.setStyle(radioCarolineButton.buttonNotClicked());
        radioCarolineButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Radio Caroline");
                stage.setScene(new Scene(parent));
                controller.setTitle("Radio Caroline (1946-1991)");
                controller.addText("Radio Caroline was created in 1964 by Ronan O'Rahilly. Following the passing of the Marine Broadcasting Offenses act in 1967, many "
                        + "pirate radio stations went out of business as they could no longer receive revenue from British advertisers and businesses. Radio Caroline maintained "
                        + "its broadcasting capabilities by hiring foreign DJ's, using foreign ships, and basing their operations out of foreign countries, such as the Netherlands, effectively "
                        + "circumventing the law. It should be noted that this was no longer as profitable as Radio Caroline could not receive direct legal revenue from its British audience. "
                        + "The station finally went offline in 1991 following the passing of Amendment 42 in 1990 which allowed British authorities to raid ships employed by Radio Caroline even in international "
                        + "waters.");
                controller.addImage("/worldtimeline/View/Caroline.jpg");
                stage.show();
                radioCarolineButton.setStyle(radioCarolineButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(radioCarolineButton);

        HistoryButton radioLuxembourgButton = new HistoryButton(1933, 1992, 544, 131, ButtonColor.PIRATE_RADIO);
        radioLuxembourgButton.setStyle(radioLuxembourgButton.buttonNotClicked());
        radioLuxembourgButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Radio Luxembourg");
                stage.setScene(new Scene(parent));
                controller.setTitle("Radio Luxembourg (1933 - 1992)");
                controller.addText("During the 1920's when radio was becoming more widely accepted, two models of radio emerged. The U.S. model of broadcasting allowed for advertising and private ownership of radio stations, the British model did not. "
                        + "This left a void in Britain as businesses were eager to advertise their products and listeners were eager for more varied content, especially due to the fact that the BBC only "
                        + "played rock music from 11-12 pm on Saturdays. Thus, Radio Luxembourg was created in 1933 to circumvent the ban on private broadcasters and market directly to a British audience. However, "
                        + "Radio Luxembourg suffered a setback in 1948 when new regulations only allowed them to broadcast at night. The demand for advertising and rock and roll in the 1950's remained and led to the creation of pirate radio stations that would operate in international waters."
                        + " It dissolved in 1992.");
                controller.addImage("/worldtimeline/View/luxembourg1.jpg");
                controller.addImage("/worldtimeline/View/luxembourg2.jpg");
                stage.show();
                radioLuxembourgButton.setStyle(radioLuxembourgButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(radioLuxembourgButton);

        HistoryButton threeWavesButton = new HistoryButton(1520, 1810, 960, 270, ButtonColor.CHINESE_PIRATES);
        threeWavesButton.setStyle(threeWavesButton.buttonNotClicked());
        threeWavesButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Three Waves of Chinese Piracy");
                stage.setScene(new Scene(parent));
                controller.setTitle("Three Waves of Chinese Piracy: Big Picture (1520 - 1810)");
                controller.addHeader("First Wave: Merchant Pirates (1520-1574)");
                controller.addText("Originated as resistance to sea bans, ended with the lifting of the bans.");
                controller.addHeader("Second Wave: Sea Rebel Piracy (1620-1684)");
                controller.addText("Originated as resistance to new, more brutal sea bans that required individuals living near the sea to move ten miles inland. "
                        + "Resistance was led by figures such as Zheng Zhilong.");
                controller.addHeader("Third Wave: High Tide of Chinese Piracy (1780-1810)");
                controller.addText("Period marked by commoner pirates that grew into large pirate enterprises. Notable groups include Zheng Yi Sao's Banner Fleets and Tayson Rebels.");
                controller.addImage("/worldtimeline/View/chinesePirates1.jpg");
                stage.show();
                threeWavesButton.setStyle(threeWavesButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(threeWavesButton);

        HistoryButton firstWaveButton = new HistoryButton(1520, 1574, 960, 250, ButtonColor.CHINESE_PIRATES);
        firstWaveButton.setStyle(firstWaveButton.buttonNotClicked());
        firstWaveButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("First Wave of Chinese Piracy");
                stage.setScene(new Scene(parent));
                controller.setTitle("First Wave of Chinese Piracy: (1520 - 1574)");
                controller.addText("Due to criminalization of a sea based lifestyle entire communities turned to piracy."
                        + " Fishermen had no real way to make a living outside of fishing, especially in South East China due"
                        + " to the mountainous region where sea travel was easiest. "
                        + "Included Wako pirates that worked alongside Chinese pirates "
                        + "against the Chinese government. It ended with the lifting of the sea bans.");
                controller.addImage("/worldtimeline/View/firstWave1.jpg");
                stage.show();
                firstWaveButton.setStyle(firstWaveButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(firstWaveButton);

        HistoryButton secondWaveButton = new HistoryButton(1620, 1684, 950, 250, ButtonColor.CHINESE_PIRATES);
        secondWaveButton.setStyle(secondWaveButton.buttonNotClicked());
        secondWaveButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Second Wave of Chinese Piracy");
                stage.setScene(new Scene(parent));
                controller.setTitle("Second Wave of Chinese Piracy: (1620 - 1684)");
                controller.addText("Occurred during the Qing dynasty after more brutal sea bans that involved moving people 10 miles inland, anyone not obeying this law would be punished with the death penalty."
                        + " This caused many communitties to resist the bans, included the Zheng Family of pirates who were known as being just. "
                        + "The pirate wave ended following the Qing decision to remove the bans.");
                controller.addImage("/worldtimeline/View/secondWave1.jpg");
                stage.show();
                secondWaveButton.setStyle(secondWaveButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(secondWaveButton);

        HistoryButton thirdWaveButton = new HistoryButton(1780, 1810, 950, 250, ButtonColor.CHINESE_PIRATES);
        thirdWaveButton.setStyle(thirdWaveButton.buttonNotClicked());
        thirdWaveButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Third Wave of Chinese Piracy");
                stage.setScene(new Scene(parent));
                controller.setTitle("Third Wave of Chinese Piracy: (1780 - 1810)");
                controller.addText("Pirating during this time escalated widely due to a population explosion that saw no increase in wealth for fishermen and locals."
                        + " Pirate groups formed, most notably in the form of the Banner Fleets."
                        + " Banner Fleets were headed by individual leaders who worked together."
                        + " The Banner Fleets resorted to extortion in the form of passes for fishermen and merchants."
                        + " Most boats opted to pay the fees, in 1805 out of 270 boats only"
                        + " 4 refused to pay. Other crimes included ransoming as well as kidnapping."
                        + " Most of the pirates on the ship were forced into the pirate lifestyle by their captors. "
                        + " Zheng Yi and his wife Zheng Yi Sao were the leaders of the Red Banner Fleet, they had an adopted son named Zheng Bao"
                        + " who would come to be the new pirate leader after Zheng Yi died in 1807."
                        + " The pirate gangs were eventually broken up by Bai Ling."
                        );
                controller.addImage("/worldtimeline/View/thirdWave1.jpg");
                stage.show();
                thirdWaveButton.setStyle(thirdWaveButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(thirdWaveButton);
    
        HistoryButton bailingButton = new HistoryButton(1809, 1810, 960, 250, ButtonColor.CHINESE_PIRATES);
        bailingButton.setStyle(bailingButton.buttonNotClicked());
        bailingButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Bai Ling's Intervention");
                stage.setScene(new Scene(parent));
                controller.setTitle("Bai Ling's Intervention (1809-1810)");
                controller.addText("Bai Ling was put in power by the Qin emperor to neutralize the pirate threat, he aimed to do so in the following manner.\n"
                        + "     -Bai Ling established a coastal blockade to prevent pirate movements and resupplying\n"
                        + "     -Established an alliance with the gentry and won them over to his side, away from the pirates influence\n"
                        + "     -Took advantage of an ongoing famine along with the blockade to further demoralize the pirates.\n"
                        + "     -Used pardons and rewards to win over pirate leaders and followers, as was the case with Zheng Yi Sao.\n"
                        + "Following Bai Ling's efforts, the pirate threat was mostly dissolved by 1810.");
                controller.setImageWidth(0);
                stage.show();
                bailingButton.setStyle(bailingButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(bailingButton);
        
        HistoryButton zhengYiSaoButton = new HistoryButton(1844, 1844, 960, 250, ButtonColor.CHINESE_PIRATES);
        zhengYiSaoButton.setStyle(zhengYiSaoButton.buttonNotClicked());
        zhengYiSaoButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("End of Zheng Yi Sao");
                stage.setScene(new Scene(parent));
                controller.setTitle("End of Zheng Yi Sao (1844)");
                controller.addText("Zheng Yi Sao dies in Macau at the age of 69 after running a gambling house and brothel following her retirement from piracy.");
                controller.setImageWidth(0);
                stage.show();
                zhengYiSaoButton.setStyle(zhengYiSaoButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(zhengYiSaoButton);

        HistoryButton originalWreckingButton = new HistoryButton(1275, 1275, 521, 120, ButtonColor.WRECKING_LAW);
        originalWreckingButton.setStyle(originalWreckingButton.buttonNotClicked());
        originalWreckingButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Wrecking Law");
                stage.setScene(new Scene(parent));
                controller.setTitle("Wrecking Law Appears in England (1275)");
                controller.addText("The idea of live and dead wrecks first originates in England.");
                controller.setImageWidth(0);
                stage.show();
                originalWreckingButton.setStyle(originalWreckingButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(originalWreckingButton);
        
        HistoryButton wreckingLawButton = new HistoryButton(1600, 1860, 525, 118, ButtonColor.WRECKING_LAW);
        wreckingLawButton.setStyle(wreckingLawButton.buttonNotClicked());
        wreckingLawButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Wrecking Law");
                stage.setScene(new Scene(parent));
                controller.setTitle("Wrecking Law: Big Picture (1600-1860)");
                controller.addText("ID Terms\n"
                        + "     Types of Wrecking\n"
                        + "     Wreck Rights - Right to take, keep, and profit from material from a shipwreck.\n"
                        + "     12 Anne and 26 George II - Laws passed that detailed actions associated with wrecking and punishments.");
                controller.addHeader("Types of Wrecks");
                controller.addText("    Live Wrecks - wrecks that had at least one survivor on them, including animals.\n"
                        + "     Dead Wrecks - wrecks that had no survivors.\n"
                        + "     Harvest - Goods that wash up on shore.\n"
                        + "     Salvage - Saving goods and/or the ship itself in order to turn it over to the authorities, done by people called salvors.\n"
                        + "     Plunder - Taking goods from a wreck, usually by force.");
                controller.addHeader("Overview");
                controller.addText("Wreck law had a long history, starting from 1275. Local tradition stipulated that ship wrecks belonged to the individuals who happened upon them, within limits to how much they could take."
                        + " The official British Law however dictated that the British Monarch or the original owner were the ones who owned the wreck, depending on whether it's a "
                        + "live wreck or a dead wreck. People would be compensated when they would salvage a wreck but many people pilfered goods anyway as they needed."
                        + " Local law enforcement would rarely punish people pilfering wrecks. "
                        + "What follows is the attempt of the British government to control wrecking rights through the passing of many new laws clarifying and detailing wrecking rights.");
                controller.addImage("/worldtimeline/View/wrecking1.jpg");
                stage.show();
                wreckingLawButton.setStyle(wreckingLawButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(wreckingLawButton);
        
        HistoryButton twelveAnneButton = new HistoryButton(1714, 1714, 520, 105, ButtonColor.WRECKING_LAW);
        twelveAnneButton.setStyle(twelveAnneButton.buttonNotClicked());
        twelveAnneButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Wrecking Law");
                stage.setScene(new Scene(parent));
                controller.setTitle("12 Anne Is Passed (1714)");
                controller.addText("'12 Anne' is passed under Queen Anne. It distinguished between wrecking offences and applied different punishments."
                        + " It allowed stopping people from going on a wreck."
                        + " It also noted that people could be punished with death for putting out false lights in order to deliberately cause wrecking.");
                controller.setImageWidth(0);
                stage.show();
                twelveAnneButton.setStyle(twelveAnneButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(twelveAnneButton);
        
        HistoryButton twentySixGeorgeButton = new HistoryButton(1753, 1753, 520, 105, ButtonColor.WRECKING_LAW);
        twentySixGeorgeButton.setStyle(twentySixGeorgeButton.buttonNotClicked());
        twentySixGeorgeButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Wrecking Law");
                stage.setScene(new Scene(parent));
                controller.setTitle("26 George Is Passed (1753)");
                controller.addText("'26 George' is passed. This law clarified some points, namely that you couldn't obstruct escape from a ship or steal ship property with violence."
                        + " It also focused on reclaiming property by allowing search and siezure. Although there were no records of false lights being used to sink ships, "
                        + "26 George specifically outlines the death penalty for the use of false lights.");
                controller.setImageWidth(0);
                stage.show();
                twentySixGeorgeButton.setStyle(twentySixGeorgeButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(twentySixGeorgeButton);
        
        HistoryButton lordMansfieldButton = new HistoryButton(1770, 1770, 515, 105, ButtonColor.WRECKING_LAW);
        lordMansfieldButton.setStyle(lordMansfieldButton.buttonNotClicked());
        lordMansfieldButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Wrecking Law");
                stage.setScene(new Scene(parent));
                controller.setTitle("Lord Mansfield Rules on Wrecking Law (1770)");
                controller.addText("Lord Mansfield rules that anything not handed over to the British government is plunder and anyone caught doing so would be punished with the death penalty."
                        + " The ruling also got rid of the concept of \"Dead Wrecks\"");
                controller.addImage("/worldtimeline/View/lordMansfield1.jpg");
                stage.show();
                lordMansfieldButton.setStyle(lordMansfieldButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(lordMansfieldButton);
        
        HistoryButton wreckSalvageActButton = new HistoryButton(1846, 1846, 520, 105, ButtonColor.WRECKING_LAW);
        wreckSalvageActButton.setStyle(wreckSalvageActButton.buttonNotClicked());
        wreckSalvageActButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Wrecking Law");
                stage.setScene(new Scene(parent));
                controller.setTitle("Wreck and Salvage Act Passed (1846)");
                controller.addText("Took wreck rights away from the monarch and gave them to government employees who would become the receivers of the wreck. Effectively removed the hereditary requirement from wrecking law.");
                controller.setImageWidth(0);
                stage.show();
                wreckSalvageActButton.setStyle(wreckSalvageActButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(wreckSalvageActButton);
        
        HistoryButton highwayMenButton = new HistoryButton(1600, 1900, 520, 95, ButtonColor.HIGHWAY_MEN);
        highwayMenButton.setStyle(highwayMenButton.buttonNotClicked());
        highwayMenButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Highway Men");
                stage.setScene(new Scene(parent));
                controller.setTitle("Highway Men");
                controller.addText("English version of bandits - held travelers up on roads, did not always hurt people, usually just focused on robbery - not murder.");
                controller.addImage("/worldtimeline/View/highwaymen1.jpg");
                stage.show();
                highwayMenButton.setStyle(highwayMenButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(highwayMenButton);
        
        HistoryButton banditButton = new HistoryButton(1600, 1900, 570, 155, ButtonColor.HIGHWAY_MEN);
        banditButton.setStyle(banditButton.buttonNotClicked());
        banditButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Highway Men");
                stage.setScene(new Scene(parent));
                controller.setTitle("Bandits - Italy");
                controller.addText("Bandits - Italian term indicating someone worked in a large gang while making a living outside of legal means.");
                controller.addImage("/worldtimeline/View/bandit1.jpg");
                stage.show();
                banditButton.setStyle(banditButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(banditButton);
        
        HistoryButton roadAgentButton = new HistoryButton(1700, 1900, 130, 155, ButtonColor.HIGHWAY_MEN);
        roadAgentButton.setStyle(roadAgentButton.buttonNotClicked());
        roadAgentButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Highway Men");
                stage.setScene(new Scene(parent));
                controller.setTitle("Road Agents");
                controller.addText("American equivalent of highwaymen\n"
                        + "Example: Yellowstone stagecoach robbery in 1872 - preying on travelers.");
                controller.addImage("/worldtimeline/View/roadAgent1.jpg");
                stage.show();
                roadAgentButton.setStyle(roadAgentButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(roadAgentButton);
        
        HistoryButton bushRangerButton = new HistoryButton(1750, 1900, 1000, 450, ButtonColor.HIGHWAY_MEN);
        bushRangerButton.setStyle(bushRangerButton.buttonNotClicked());
        bushRangerButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Highway Men");
                stage.setScene(new Scene(parent));
                controller.setTitle("Bush Rangers");
                controller.addText("Bush Ranger - Australian version of highwaymen Ex. Ned Kelly");
                controller.addImage("/worldtimeline/View/nedKelly1.jpg");
                stage.show();
                bushRangerButton.setStyle(bushRangerButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(bushRangerButton);

        HistoryButton footPadButton = new HistoryButton(1600, 1900, 500, 125, ButtonColor.HIGHWAY_MEN);
        footPadButton.setStyle(footPadButton.buttonNotClicked());
        footPadButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Highway Men");
                stage.setScene(new Scene(parent));
                controller.setTitle("Footpads");
                controller.addText("Footpad - Galeic term for thives who operated in outside areas and often had to murder their victims as footpads didn't have a chance to get away.\n");
                controller.addImage("/worldtimeline/View/footpad1.jpg");
                stage.show();
                footPadButton.setStyle(footPadButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(footPadButton);
        
        HistoryButton thugButton = new HistoryButton(1600, 1900, 820, 230, ButtonColor.HIGHWAY_MEN);
        thugButton.setStyle(thugButton.buttonNotClicked());
        thugButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Highway Men");
                stage.setScene(new Scene(parent));
                controller.setTitle("Thugs");
                controller.addText("Based in Uttar Pradesh, Thugs were practicers of Thuggee. They were subsistence farmers who counted on robbing and murdering people in order to make money."
                        + " Expeditions would be sent out where the Zamindar would provide capital for the expedition which the Thugs would repay after returning from the expedition. The expedition included "
                        + "going out to widely traveled roads, befriending travelers, and murdering them in their sleep and robbing them after.");
                controller.addImage("/worldtimeline/View/thuggee1.jpg");
                stage.show();
                thugButton.setStyle(thugButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(thugButton);
        
        HistoryButton somaliPirateButton = new HistoryButton(1960, 2018, 705, 330, ButtonColor.SOMALI_PIRATE);
        somaliPirateButton.setStyle(somaliPirateButton.buttonNotClicked());
        somaliPirateButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Somali Pirates");
                stage.setScene(new Scene(parent));
                controller.setTitle("Somali Pirates: Big Picture(1969-?)");
                controller.addText("After Somalia was granted independence in 1960, the first democratically elected president was murdered by his bodyguards in 1969. Following this event, Siad Barre takes "
                        + "over Somalia as a dictator and plunges the country into a violent period that also damaged the economy. He worked by seperating the tribes and clans of Somalia and implementing poor "
                        + "economic policy that would eventually impoverish the country. By 1991 Barre flees Somalia, after which the country creates a number of new autonomous governments including the Somaliland Republic, "
                        + "and Puntland. The Islamic Emirate of Somalia emerges during this time period, it is run by the Al Shabab terrorists in the south of the country. With high unemployment and widespread violence, "
                        + "piracy begins to occur.");
                controller.addHeader("Four Phases of Somali Pirates");
                controller.addText("1990's - 2002 : Eyl fishermen such as Bogah and Garaad attack fishing trawlers since Somalia doesn't have a coast guard that can protect them from foreign fishermen.\n"
                        + "2003 - 2007: Somali Marines are formed under Afweyne, the range of attacks increases.\n"
                        + "2008 - 2012: Explosion of piracy - targets begin to include large commercial ships.\n"
                        + "2013 - present: Decline of piracy through 2016, followed by an upsurge in 2017.");
                controller.addImage("/worldtimeline/View/somali1.jpg");
                controller.addImage("/worldtimeline/View/somali2.jpg");
                stage.show();
                somaliPirateButton.setStyle(somaliPirateButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(somaliPirateButton);
        
        HistoryButton somaliAssassinationButton = new HistoryButton(1969, 1969, 705, 313, ButtonColor.SOMALI_PIRATE);
        somaliAssassinationButton.setStyle(somaliAssassinationButton.buttonNotClicked());
        somaliAssassinationButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Somali Pirates");
                stage.setScene(new Scene(parent));
                controller.setTitle("President President Abdirashid Ali Sharmarke Assassinated (1969)");
                controller.addText("The assassination of the Somalian president in Las Anod gives control of the country to Siad Barre,"
                        + " who rules the country as a dictator and destroys the economy of Somalia while doing so.");
                controller.addImage("/worldtimeline/View/somaliaPresident1.jpg");
                stage.show();
                somaliAssassinationButton.setStyle(somaliAssassinationButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(somaliAssassinationButton);
        
        HistoryButton fainaButton = new HistoryButton(2008, 2008, 720, 313, ButtonColor.SOMALI_PIRATE);
        fainaButton.setStyle(fainaButton.buttonNotClicked());
        fainaButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Somali Pirates");
                stage.setScene(new Scene(parent));
                controller.setTitle("M.V. Faina Captured (2008)");
                controller.addText("The M.V. Faina is captured by Somali pirates, it was carrying weapons. The crew is eventually freed in 2009 after a ransom totalling 3.2 million dollars was paid to the pirates.");
                controller.addImage("/worldtimeline/View/faina1.jpg");
                stage.show();
                fainaButton.setStyle(fainaButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(fainaButton);
        
        HistoryButton bodySnatchingButton = new HistoryButton(1700, 1900, 517, 115, ButtonColor.BODY_SNATCHING);
        bodySnatchingButton.setStyle(bodySnatchingButton.buttonNotClicked());
        bodySnatchingButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Body Snatching");
                stage.setScene(new Scene(parent));
                controller.setTitle("Body Snatching: Big Picture(1700-1900)");
                controller.addText("During the 1700's and 1800's, corpse snatching was endemic. The demand for bodies driven by medical schools and anatomists drove "
                        + "many people to turn to grave robbing. The public was against this practice, it was widely believed that the body and soul were still together"
                        + " prior to the burial and that the desecration of the body would affect the soul in the afterlife. In the 1400's to the 1700's,"
                        + " surgeons were seen more along the lines of laborers. Corpses were often retrieved through slums, hospitals, prisons, the poor house, and grave"
                        + " robbing. In the 1800's, surgeons were being viewed as professionals. The College of Surgeons was involved in petitioning for keeping their status "
                        + "as the only place that could legally receive bodies. \n"
                        + "     The 1832 Anatomy Act worked to normalise the way bodies were distributed.\n"
                        + "-Ended company of surgeons monopoly on bodies.\n"
                        + "-Ended practice of dissecting murderers in order to normalise dissection.\n"
                        + "-If a body was unclaimed for 72 hours by a family member in a hospital, prison, or poor house, body would be given to anatomists.\n"
                        + "-New position was created, Inspector of Anatomy, would work to make sure rules were being followed.\n"
                        + "-Criticism came from the fact that there wasn't enough time to claim the bodies, and family friends couldn't claim bodies.\n"
                        + "-Didn't make unauthorized disinternment illegal nor sale of bodies or body parts illegal\n"
                        );
                controller.addImage("/worldtimeline/View/bodySnatching1.png");
                controller.addImage("/worldtimeline/View/bodySnatching2.jpg");
                controller.addImage("/worldtimeline/View/bodySnatching3.gif");
                stage.show();
                bodySnatchingButton.setStyle(bodySnatchingButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(bodySnatchingButton);
        
        HistoryButton murderActButton = new HistoryButton(1752, 1752, 517, 125, ButtonColor.BODY_SNATCHING);
        murderActButton.setStyle(murderActButton.buttonNotClicked());
        murderActButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Body Snatching");
                stage.setScene(new Scene(parent));
                controller.setTitle("Murder Act (1752)");
                controller.addText("Expanded pool of bodies available to medical schools. The wording of the act indicated it was still being seen as a punishment.");
                controller.setImageWidth(0);
                stage.show();
                murderActButton.setStyle(murderActButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(murderActButton);
        
        HistoryButton uOfFlorenceButton = new HistoryButton(1387, 1387, 568, 159, ButtonColor.BODY_SNATCHING);
        uOfFlorenceButton.setStyle(uOfFlorenceButton.buttonNotClicked());
        uOfFlorenceButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Body Snatching");
                stage.setScene(new Scene(parent));
                controller.setTitle("University of Florence (1387)");
                controller.addText("University of Florence legally receives corpses of criminals.");
                controller.addImage("/worldtimeline/View/florence1.jpg");
                stage.show();
                uOfFlorenceButton.setStyle(uOfFlorenceButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(uOfFlorenceButton);
        
        HistoryButton newYorkPetitionButton = new HistoryButton(1788, 1788, 255, 175, ButtonColor.BODY_SNATCHING);
        newYorkPetitionButton.setStyle(newYorkPetitionButton.buttonNotClicked());
        newYorkPetitionButton.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/worldtimeline/View/GenericTemplate.fxml"));
                Parent parent = (Parent) fxmlLoader.load();
                GenericTemplateController controller = (GenericTemplateController) fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setTitle("Body Snatching");
                stage.setScene(new Scene(parent));
                controller.setTitle("Petition to Stop Grave Robbing (1788)");
                controller.addText("A petition is presented to the New York Mayor encouraging him to ban grave robbing. The lack of action on behalf of the mayor "
                        + "eventually leads to riots against anatomy students.");
                controller.setImageWidth(0);
                stage.show();
                newYorkPetitionButton.setStyle(newYorkPetitionButton.buttonClicked());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        buttons.add(newYorkPetitionButton);

    }

}
