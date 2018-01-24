// Been a while since I used this, but here we go. Building a doggo class
// 
// Wonder what need to import
import java.util.Random;

public class Dog {
  public int loveU = 1;                                                        // separate place for how doggo feels about player
  public Map<String, Integer> relStats = new HashMap<String, Integer>();       // init relationship stats
  public Map<String, Integer> perStats = new HashMap<String, Integer>();       // init personal stats
  public string name; 
  private Random rand = new Random();
  private static final String[] fullNames = {"Gayle", "Sam", "Hayden", "Elex", "Grae", "Aaron", "Guy", "Cameron", "Kayla", "Lucy", "Bolt", "Naomi", "Missy"};
  private static final String[] fullStat = {"Cud", "Play", "Indep"};
  
  // Initialize Dog with nothing. Should never enter this
  public Dog() {
    this("");
  }
  
  public Dog(string name) {
    this.name = name;
    // Randomize Personal Stats
    for (String currStat : this.fullStat) {
      this.perStats.put(currStat, rand.nextInt(10) + 1);
    }
    // Randomize Relationship Stats, Missy is 10 for all, Lucy and Bolt will be the same
    for (String currName : this.fullNames) {
      if (currName != name) {                                                     // only enter if it's a name of another dog
        if (currName == "Missy" || (name == "Bolt" && currName == "Lucy") || (name == "Lucy" && currName == "Bolt")) {                                                
          this.relStats.put(currName, 10);                                        // set relationship to missy as 10 and Lucy / Bolt rleationship to 10
        } else if (currName == "Bolt" && this.relStats.get("Lucy") != null) {     // if Lucy already created, set Bolt to same relationship level
          this.relStats.put(currName, this.relStats.get("Lucy"));
        } else if (currName == "Lucy" && this.relStats.get("Bolt") != null) {     // if Bolt already created, set Lucy to same relationship level
          this.relStats.put(currName, this.relStats.get("Bolt"));
        } else {
          this.relStats.put(currName, rand.nextInt(10) + 1);
        }
      }
    }
  }
  
}

