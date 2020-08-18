package com.example.android.sacktest;

import java.util.ArrayList;


public class EndStoryScene {
    private static ArrayList<EndStoryScene> DateEndStoryScenes, BarEndStoryScenes, StreetEndStoryScenes, PartyEndStoryScenes;
    private int id;
    private String endStoryScene, whatYouShouldDo;


    private EndStoryScene(int id, String endStoryScene, String whatYouShouldDo) {
        this.id = id;
        this.endStoryScene = endStoryScene;
        this.whatYouShouldDo = whatYouShouldDo;
    }

    public static void iniDateEndStoryScene() {
        DateEndStoryScenes = new ArrayList<>();
        DateEndStoryScenes.add(new EndStoryScene(-1, "Later you and your date are walking home are walking home. It seems that your date is making inappropriate advances on you which is making you feel uncomfortable.", ""));
        DateEndStoryScenes.add(new EndStoryScene(-2, "Well, it seems that you have made a good choice.", "you need to..."));
    }

    public static void iniBarEndStoryScene() {
        BarEndStoryScenes = new ArrayList<>();
        BarEndStoryScenes.add(new EndStoryScene(-1, "Your friend may or may not have been okay with this, but it is better to be safe than sorry.", ""));
        BarEndStoryScenes.add(new EndStoryScene(-2, "Your friend says that they are not okay with the person dancing with them.", "You should seek assistance from bar staff or some other friends to remove your friend from this potentially dangerous scenario"));
    }

    public static void iniStreetEndStoryScene() {
        StreetEndStoryScenes = new ArrayList<>();
        StreetEndStoryScenes.add(new EndStoryScene(-1, "That could potentially very dangerous", "Call the police or any nearby security to safely handle the situation. Stay nearby until help arrives and make sure you're able to get home safe"));
        StreetEndStoryScenes.add(new EndStoryScene(-2, "You want to help because the cries continue, but it could be potentially dangerous.", "Call the police or any nearby security to safely handle the situation. Stay nearby until help arrives and make sure you're able to get home safe"));
        StreetEndStoryScenes.add(new EndStoryScene(-3, "You keep walking fast and making turn however the person is still behind you keeping up.", "Finding a well lit area that is busy should be your first action. If this is not available look for a house with lights on, knocking on the door should be your next action."+"\n"+"In the future, always walk with a firent avoid dark or poorly lit areas. Take advantage of serves such as walk home."));
    }

    public static void iniPartyEndStoryScene() {
        PartyEndStoryScenes = new ArrayList<>();
        PartyEndStoryScenes.add(new EndStoryScene(-1, "What's happening is getting worse and its starting to really bother you. You try and get the help of other people in the room but no one seems to care and won't help you.", "In a situation like this where you are physically unable to do anything and can't get help from anyone nearby it is time to seek help from another source. Calling the police or a form of campus security and explaining the situation and allowing them to come solve the problem is the best thing you can do at this point."));

    }

    public static ArrayList<EndStoryScene> getDateEndStoryScenes() {
        return DateEndStoryScenes;
    }

    public static ArrayList<EndStoryScene> getBarEndStoryScenes() {
        return BarEndStoryScenes;
    }

    public static ArrayList<EndStoryScene> getStreetEndStoryScenes() {
        return StreetEndStoryScenes;
    }

    public static ArrayList<EndStoryScene> getPartyEndStoryScenes() {
        return PartyEndStoryScenes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndStoryScene() {
        return endStoryScene;
    }

    public void setEndStoryScene(String endStoryScene) {
        this.endStoryScene = endStoryScene;
    }

    public String getWhatYouShouldDo() {
        return whatYouShouldDo;
    }

    public void setWhatYouShouldDo(String whatYouShouldDo) {
        this.whatYouShouldDo = whatYouShouldDo;
    }
}



