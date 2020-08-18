package com.example.android.sacktest;

import java.util.ArrayList;

/**
 * Created by Bill Tong on 3/13/2018.
 */

public class StoryScene {
    private static ArrayList<StoryScene> DateStoryScenes, StreetStoryScenes, PartyStoryScenes, BarStoryScenes;
    private int sceneId;
    private String storyScene;
    private String choice1;
    private String choice2;
    //end next will add 00
    private int choice_1_next;
    private int choice_2_next;


    private StoryScene(int sceneId, String storyScene, String choice1, String choice2, int choice_1_next, int choice_2_next) {
        this.sceneId = sceneId;
        this.storyScene = storyScene;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice_1_next = choice_1_next;
        this.choice_2_next = choice_2_next;
    }

    // build the tree for two different
    public static void iniDateStoryScenes() {
        DateStoryScenes = new ArrayList<>();
        DateStoryScenes.add(new StoryScene(1, "You are at a restaurant on a first date with someone you met on the internet. The date is going okay however, your date seems to be making a lot of sexual references and it is making you uncomfortable.", "Ask him what his intentions are", "Laugh it off", 2, -1));
        DateStoryScenes.add(new StoryScene(2, "Your date gets very defensive and says that he was just making jokes.", "Decide to leave", "Say that you're sorry for taking his jokes in that way.", -2, -1));
    }

    public static void iniStreetStoryScenes() {
        StreetStoryScenes = new ArrayList<>();
        StreetStoryScenes.add(new StoryScene(1, "It is the tailend of a long night out and it's time to go home. You're waiting for your friends but they're being particularly slow and you decide to walk home without them. On your way home, you remember a shortcut you often take through an alley which gets you home the fastest. Which route do you take?", "Stay on the main street", "Take the alleyway shortcut", 2, 4));
        StreetStoryScenes.add(new StoryScene(2, "As you are walking home, you pass by an alleyway and hear cries coming from within. It sounds like something quite violent is about to happen.", "Go inside the alley", "Continue walking", -1, 3));
        StreetStoryScenes.add(new StoryScene(3, "Wait a second. This action may have deep consequences to the person who is being attacked. There may be better ways to solve this.", "Swipe ether right or left to check what to do.", "", -1, -1));
        StreetStoryScenes.add(new StoryScene(4, "In the alley, you notice that someone appears to be following you, there is no clear way to get to a main street and no one else is nearby. Do you", "Call a friend", "Walk faster", 5, -3));
        StreetStoryScenes.add(new StoryScene(5, "Your friend tells you that they took a different route home and will take a while to get to you", "You decide to walk faster", "You decide to keep walking", -3, -3));

    }

    public static void iniPartyStoryScenes() {
        PartyStoryScenes = new ArrayList<>();
        PartyStoryScenes.add(new StoryScene(1, "You've just arrived at a party and you notice someone that has had too much to drink. You see two other people messing and filming the person under the influence.", "Leave it.", "Try to intervene.", -1, 2));
        PartyStoryScenes.add(new StoryScene(2, "When you try to intervene you get pushed away and there is nothing you can physically do to stop them.", "Continue", "Continue", -1, -1));



    }

    public static void iniBarStoryScenes() {
        BarStoryScenes = new ArrayList<>();
        BarStoryScenes.add(new StoryScene(1, "You're at the bar with your friends. You and your friends decide to go and dance on the dance floor. You notice someone lurking around your drinks. What do you do?", "Throw out the drinks", "approach the person", 2, 3));
        BarStoryScenes.add(new StoryScene(2, "You go back to the dance floor and notice someone dancing with your friend and you can't see if your friend is okay with this. You should:", "Grab your friend and pull them away", "Ask them if they are okay", -1, -2));
        BarStoryScenes.add(new StoryScene(3, "You should not approach the person, it could be dangerous! You could possibly ask staff for help.", "Throw our the drinks", "Throw out the drinks", 2, 2));



    }

    public static ArrayList<StoryScene> getDateStoryScenes() {
        return DateStoryScenes;
    }

    public static void setDateStoryScenes(ArrayList<StoryScene> dateStoryScenes) {
        DateStoryScenes = dateStoryScenes;
    }

    public static ArrayList<StoryScene> getStreetStoryScenes() {
        return StreetStoryScenes;
    }

    public static void setStreetStoryScenes(ArrayList<StoryScene> streetStoryScenes) {
        StreetStoryScenes = streetStoryScenes;
    }

    public static ArrayList<StoryScene> getPartyStoryScenes() {
        return PartyStoryScenes;
    }

    public static void setPartyStoryScenes(ArrayList<StoryScene> partyStoryScenes) {
        PartyStoryScenes = partyStoryScenes;
    }

    public static ArrayList<StoryScene> getBarStoryScenes() {
        return BarStoryScenes;
    }

    public static void setBarStoryScenes(ArrayList<StoryScene> barStoryScenes) {
        BarStoryScenes = barStoryScenes;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getStoryScene() {
        return storyScene;
    }

    public void setStoryScene(String storyScene) {
        this.storyScene = storyScene;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public int getChoice_1_next() {
        return choice_1_next;
    }

    public void setChoice_1_next(int choice_1_next) {
        this.choice_1_next = choice_1_next;
    }

    public int getChoice_2_next() {
        return choice_2_next;
    }

    public void setChoice_2_next(int choice_2_next) {
        this.choice_2_next = choice_2_next;
    }
}
