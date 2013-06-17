/**
 * JointTest.java
 * @author Lianne Meah
 * A simple command line based class to test joints
*/

import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import static org.robokind.api.motion.Robot.*;
import org.robokind.client.basic.Robokind;
import static org.robokind.client.basic.RobotJoints.*;
import org.robokind.client.basic.UserSettings;

public class JointTest {
	// variables for class
	private static int jointIndex;
	private static Boolean printOut;
	private static int timeFrame;
	private static double interval;
        private static RemoteRobot myRobot;
        private static RobotPositionMap myGoalPositions;
        
        /*
         * Main method for testing
         * Purge later
         */
        public static void main(String[] args) {
            String robotID = "myRobot";
            String robotIP = "192.168.0.54";
            // set respective addresses
            UserSettings.setRobotId(robotID);
            UserSettings.setRobotAddress(robotIP);
            UserSettings.setAnimationAddress(robotIP);
            // try to make connections
            myRobot = Robokind.connectRobot();
            // joint index x, over 1000 milliseconds, 0.1 steps, with printing turned on
            if (myRobot.isConnected()) {
                JointTest test = new JointTest(301, 0.1, 1000, true);
            }
        }
	/*
	 * Default constructor
	 */
	public JointTest() {

	}

	/** 
	 * Constructor
	 * @param jointIndex the index number of the joint; indices given in RobotJoints.java
	 * @param interval the increment size for each test
	 * @param timeFrame the number of milliseconds to move the joint over - suggested 1000
	 * @param printOut boolean for printing, if set to true then will print to console
	 */
	public JointTest(int jointIndex, double interval, int timeFrame, Boolean printOut) {
		this.jointIndex = jointIndex;
		this.interval = interval;
		this.timeFrame = timeFrame;
		this.printOut = printOut;
		JointId joint;
		// run a switch statement on the joint index
		switch (this.jointIndex) {
			// set joint
			case 100: joint = new JointId(myRobot.getRobotId(), new Joint.Id(WAIST));
				break;
			case 200: joint = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_YAW));
				break;
			case 201: joint = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_ROLL));
				break;
			case 202: joint = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_PITCH));
				break;
			case 300: joint = new JointId(myRobot.getRobotId(), new Joint.Id(BROWS));
				break;
			case 301: joint = new JointId(myRobot.getRobotId(), new Joint.Id(EYELIDS));
				break;
			case 310: joint = new JointId(myRobot.getRobotId(), new Joint.Id(EYES_PITCH));
				break;
			case 311: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_EYE_YAW));
				break;
			case 312: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_EYE_YAW));
				break;				
			case 320: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SMILE));
				break;
			case 321: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SMILE));
				break;				
			case 322: joint = new JointId(myRobot.getRobotId(), new Joint.Id(JAW));
				break;
			case 400: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_PITCH));
				break; 
			case 401: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_ROLL));
				break;
			case 410: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_YAW));
				break;
			case 411: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_PITCH));
				break;
			case 420: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_WRIST_YAW));
				break;
			case 421: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HAND_GRASP));
				break;
			case 500: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SHOULDER_PITCH));
				break; 
			case 501: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SHOULDER_ROLL));
				break;
			case 510: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ELBOW_YAW));
				break;
			case 511: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ELBOW_PITCH));
				break;
			case 520: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_WRIST_YAW));
				break;
			case 521: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HAND_GRASP));
				break;
			case 600: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HIP_ROLL));
				break;
			case 601: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HIP_YAW));
				break;	
			case 602: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HIP_PITCH));
				break;
			case 610: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_KNEE_PITCH));
				break;
			case 620: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ANKLE_PITCH));
				break;
			case 621: joint = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ANKLE_ROLL));
				break;
			case 700: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HIP_ROLL));
				break;
			case 701: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HIP_YAW));
				break;	
			case 702: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HIP_PITCH));
				break;
			case 710: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_KNEE_PITCH));
				break;
			case 720: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ANKLE_PITCH));
				break;
			case 721: joint = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ANKLE_ROLL));
				break;				
			default: joint = new JointId(myRobot.getRobotId(), new Joint.Id(WAIST));
		}
        // make positions hash map
        myGoalPositions = new RobotPositionHashMap(); 

        // loop; testing joints. Start at 0.1 and move up
        for (double i = 0.0; i<=1.0; i+=this.interval) {
        	// printing
        	if (this.printOut) {
        		System.out.println("Moving joint to position "+i+" over "+this.timeFrame+" milliseconds:");
        	}
        	myGoalPositions.put(joint, new NormalizedDouble(i));
			// move over specified time
        	myRobot.move(myGoalPositions, this.timeFrame);  
                Robokind.sleep(2000);
        }
        // completion message
  		System.out.println("Test complete using joint number: "+this.jointIndex);
  		double defaultPosition;
  		// There has GOT to be an easier way of doing this...
  		switch (this.jointIndex) {
			// set joint
			case 100: defaultPosition = 0.5; //DONE
				break;
			case 200: defaultPosition = 0.5; //DONE
				break;
			case 201: defaultPosition = 0.5; //DONE
				break;
			case 202: defaultPosition = 0.5; //DONE
				break;
			case 300: defaultPosition = 0.542372881355932; //DONE
				break;
			case 301: defaultPosition = 0.442105263157895; //DONE
				break;
			case 310: defaultPosition = 0.67; //DONE
				break;
			case 311: defaultPosition = 0.5; //DONE
				break;
			case 312: defaultPosition = 0.5; //DONE
				break;				
			case 320: defaultPosition = 0.5; //DONE
				break;
			case 321: defaultPosition = 0.5; //DONE
				break;				
			case 322: defaultPosition = 0.364464692482916; //DONE
				break;
			case 400: defaultPosition = 0.185185185185185; //DONE
				break; 
			case 401: defaultPosition = 0.055555555555556; //DONE
				break;
			case 410: defaultPosition = 0.5; //DONE
				break;
			case 411: defaultPosition = 0.111111111111111; //DONE
				break;
			case 420: defaultPosition = 0.5; //DONE
				break;
			case 421: defaultPosition = 0.5; //grasp
				break;
			case 500: defaultPosition = 0.185185185185185; //DONE
				break; 
			case 501: defaultPosition = 0.055555555555556; //DONE
				break;
			case 510: defaultPosition = 0.5; //DONE
				break;
			case 511: defaultPosition = 0.111111111111111; //DONE
				break;
			case 520: defaultPosition = 0.5; //DONE
				break;
			case 521: defaultPosition = 0.5; //grasp
				break;
			case 600: defaultPosition = 0.2; //DONE
				break;
			case 601: defaultPosition = 0.181818181818182; //DONE
				break;	
			case 602: defaultPosition = 0.1; //DONE
				break;
			case 610: defaultPosition = 0.909090909090909; //DONE
				break;
			case 620: defaultPosition = 0.7; //DONE
				break;
			case 621: defaultPosition = 0.5; //DONE
				break;
			case 700: defaultPosition = 0.2; //DONE
				break;
			case 701: defaultPosition = 0.818181818181818; //DONE
				break;	
			case 702: defaultPosition = 0.1; //DONE
				break;
			case 710: defaultPosition = 0.909090909090909; //DONE
				break;
			case 720: defaultPosition = 0.7; //DONE
				break;
			case 721: defaultPosition = 0.5; //DONE
				break;				
			default: defaultPosition = 0.5; //DONE
		}
		if (printOut) {
			System.out.println("Now setting joint to default value: "+defaultPosition);
		}	
  		// set to default
		myGoalPositions.put(joint, new NormalizedDouble(defaultPosition));
		// move over 2000 milliseconds
                myRobot.move(myGoalPositions, 2000);
	}
}