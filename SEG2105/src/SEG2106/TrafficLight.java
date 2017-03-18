package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/

import SEG2106.core.TrafficLightManager;

// line 1 "model.ump"
//%% NEW FILE TrafficLight BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-980fc67 modeling language!*/



//line 2 "model.ump"
public class TrafficLight implements EventHandler
{

//------------------------
// MEMBER VARIABLES
//------------------------

//TrafficLight State Machines
public enum Status { low, moderate, high }
public enum StatusLow { Null, northAndSouthArrow1, northAndSouthGreenWithoutArrow1, northAndSouthYellow1, northAndSouthRed1, westAndEastYellow1 }
public enum StatusModerate { Null, northGreenArrow2, northYellow2, northRed2, southYellow2, southRed2, westAndEastYellow2 }
public enum StatusHigh { Null, northGreenArrow3, northYellow3, northRed3, southYellow3, southRed3, westGreenWithOutArrow3, westAndEastYellow3 }
private Status status;
private StatusLow statusLow;
private StatusModerate statusModerate;
private StatusHigh statusHigh;
private TrafficLightManager trafficLightManager; 

//------------------------
// CONSTRUCTOR
//------------------------

public TrafficLight(TrafficLightManager trafficLightManager)

{
	this.trafficLightManager = trafficLightManager;
	trafficLightManager.addEventHandler(this);
  setStatusLow(StatusLow.Null);
  setStatusModerate(StatusModerate.Null);
  setStatusHigh(StatusHigh.Null);
  setStatus(Status.high);// change this to change status (low,moderate,high)
}

//------------------------
// INTERFACE
//------------------------

public TrafficLight()
{
  setStatusLow(StatusLow.Null);
  setStatusModerate(StatusModerate.Null);
  setStatusHigh(StatusHigh.Null);
  setStatus(Status.low);
}

//------------------------
// INTERFACE
//------------------------

public String getStatusFullName()
{
  String answer = status.toString();
  if (statusLow != StatusLow.Null) { answer += "." + statusLow.toString(); }
  if (statusModerate != StatusModerate.Null) { answer += "." + statusModerate.toString(); }
  if (statusHigh != StatusHigh.Null) { answer += "." + statusHigh.toString(); }
  return answer;
}

public Status getStatus()
{
  return status;
}

public StatusLow getStatusLow()
{
  return statusLow;
}

public StatusModerate getStatusModerate()
{
  return statusModerate;
}

public StatusHigh getStatusHigh()
{
  return statusHigh;
}

private boolean enterLow()
{
  boolean wasEventProcessed = false;
  
  StatusLow aStatusLow = statusLow;
  switch (aStatusLow)
  {
    case Null:
      setStatusLow(StatusLow.northAndSouthArrow1);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

private boolean exitLow()
{
  boolean wasEventProcessed = false;
  
  StatusLow aStatusLow = statusLow;
  switch (aStatusLow)
  {
    case northAndSouthArrow1:
      setStatusLow(StatusLow.Null);
      wasEventProcessed = true;
      break;
    case northAndSouthGreenWithoutArrow1:
      setStatusLow(StatusLow.Null);
      wasEventProcessed = true;
      break;
    case northAndSouthYellow1:
      setStatusLow(StatusLow.Null);
      wasEventProcessed = true;
      break;
    case northAndSouthRed1:
      setStatusLow(StatusLow.Null);
      wasEventProcessed = true;
      break;
    case westAndEastYellow1:
      setStatusLow(StatusLow.Null);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

public boolean timerGreen()
{
  boolean wasEventProcessed = false;
  
  StatusLow aStatusLow = statusLow;
  StatusModerate aStatusModerate = statusModerate;
  StatusHigh aStatusHigh = statusHigh;
  switch (aStatusLow)
  {
    case northAndSouthArrow1:
      setStatusLow(StatusLow.northAndSouthGreenWithoutArrow1);
      wasEventProcessed = true;
      break;
    case northAndSouthGreenWithoutArrow1:
      setStatusLow(StatusLow.northAndSouthYellow1);
      wasEventProcessed = true;
      break;
    case northAndSouthRed1:
      setStatusLow(StatusLow.westAndEastYellow1);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  switch (aStatusModerate)
  {
    case northGreenArrow2:
      setStatusModerate(StatusModerate.northYellow2);
      wasEventProcessed = true;
      break;
    case northRed2:
      setStatusModerate(StatusModerate.southYellow2);
      wasEventProcessed = true;
      break;
    case southRed2:
      setStatusModerate(StatusModerate.westAndEastYellow2);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  switch (aStatusHigh)
  {
    case northGreenArrow3:
      setStatusHigh(StatusHigh.northYellow3);
      wasEventProcessed = true;
      break;
    case northRed3:
      setStatusHigh(StatusHigh.southYellow3);
      wasEventProcessed = true;
      break;
    case southRed3:
      setStatusHigh(StatusHigh.westGreenWithOutArrow3);
      wasEventProcessed = true;
      break;
    case westGreenWithOutArrow3:
      setStatusHigh(StatusHigh.westAndEastYellow3);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

public boolean timerYellow()
{
  boolean wasEventProcessed = false;
  
  StatusLow aStatusLow = statusLow;
  StatusModerate aStatusModerate = statusModerate;
  StatusHigh aStatusHigh = statusHigh;
  switch (aStatusLow)
  {
    case northAndSouthYellow1:
      setStatusLow(StatusLow.northAndSouthRed1);
      wasEventProcessed = true;
      break;
    case westAndEastYellow1:
      setStatusLow(StatusLow.northAndSouthArrow1);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  switch (aStatusModerate)
  {
    case northYellow2:
      setStatusModerate(StatusModerate.northRed2);
      wasEventProcessed = true;
      break;
    case southYellow2:
      setStatusModerate(StatusModerate.southRed2);
      wasEventProcessed = true;
      break;
    case westAndEastYellow2:
      setStatusModerate(StatusModerate.northGreenArrow2);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  switch (aStatusHigh)
  {
    case northYellow3:
      setStatusHigh(StatusHigh.northRed3);
      wasEventProcessed = true;
      break;
    case southYellow3:
      setStatusHigh(StatusHigh.southRed3);
      wasEventProcessed = true;
      break;
    case westAndEastYellow3:
      setStatusHigh(StatusHigh.northGreenArrow3);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

private boolean enterModerate()
{
  boolean wasEventProcessed = false;
  
  StatusModerate aStatusModerate = statusModerate;
  switch (aStatusModerate)
  {
    case Null:
      setStatusModerate(StatusModerate.northGreenArrow2);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

private boolean exitModerate()
{
  boolean wasEventProcessed = false;
  
  StatusModerate aStatusModerate = statusModerate;
  switch (aStatusModerate)
  {
    case northGreenArrow2:
      setStatusModerate(StatusModerate.Null);
      wasEventProcessed = true;
      break;
    case northYellow2:
      setStatusModerate(StatusModerate.Null);
      wasEventProcessed = true;
      break;
    case northRed2:
      setStatusModerate(StatusModerate.Null);
      wasEventProcessed = true;
      break;
    case southYellow2:
      setStatusModerate(StatusModerate.Null);
      wasEventProcessed = true;
      break;
    case southRed2:
      setStatusModerate(StatusModerate.Null);
      wasEventProcessed = true;
      break;
    case westAndEastYellow2:
      setStatusModerate(StatusModerate.Null);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

private boolean enterHigh()
{
  boolean wasEventProcessed = false;
  
  StatusHigh aStatusHigh = statusHigh;
  switch (aStatusHigh)
  {
    case Null:
      setStatusHigh(StatusHigh.northGreenArrow3);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

private boolean exitHigh()
{
  boolean wasEventProcessed = false;
  
  StatusHigh aStatusHigh = statusHigh;
  switch (aStatusHigh)
  {
    case northGreenArrow3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    case northYellow3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    case northRed3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    case southYellow3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    case southRed3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    case westGreenWithOutArrow3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    case westAndEastYellow3:
      setStatusHigh(StatusHigh.Null);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

private void exitStatus()
{
  switch(status)
  {
    case low:
      exitLow();
      break;
    case moderate:
      exitModerate();
      break;
    case high:
      exitHigh();
      break;
  }
}

private void setStatus(Status aStatus)
{
  status = aStatus;

  // entry actions and do activities
  switch(status)
  {
    case low:
      if (statusLow == StatusLow.Null) { setStatusLow(StatusLow.northAndSouthArrow1); }
      break;
    case moderate:
      if (statusModerate == StatusModerate.Null) { setStatusModerate(StatusModerate.northGreenArrow2); }
      break;
    case high:
      if (statusHigh == StatusHigh.Null) { setStatusHigh(StatusHigh.northGreenArrow3); }
      break;
  }
}

private void setStatusLow(StatusLow aStatusLow)
{
  statusLow = aStatusLow;
  if (status != Status.low && aStatusLow != StatusLow.Null) { setStatus(Status.low); }

  // entry actions and do activities
  switch(statusLow)
  {
    case northAndSouthArrow1:
      // line 7 "model.ump"
      trafficLightManager.northArrow();
      // line 8 "model.ump"
      trafficLightManager.southArrow();
      // line 9 "model.ump"
      trafficLightManager.eastRed();
      // line 10 "model.ump"
      trafficLightManager.westRed();
      break;
    case northAndSouthGreenWithoutArrow1:
      // line 14 "model.ump"
      trafficLightManager.northGreen();
      // line 15 "model.ump"
      trafficLightManager.southGreen();
      // line 16 "model.ump"
      trafficLightManager.eastRed();
      // line 17 "model.ump"
      trafficLightManager.westRed();
      break;
    case northAndSouthYellow1:
      // line 21 "model.ump"
      trafficLightManager.northYellow();
      // line 22 "model.ump"
      trafficLightManager.southYellow();
      // line 23 "model.ump"
      trafficLightManager.eastRed();
      // line 24 "model.ump"
      trafficLightManager.westRed();
      break;
    case northAndSouthRed1:
      // line 28 "model.ump"
      trafficLightManager.northRed();
      // line 29 "model.ump"
      trafficLightManager.southRed();
      // line 30 "model.ump"
      trafficLightManager.eastGreen();
      // line 31 "model.ump"
      trafficLightManager.westGreen();
      break;
    case westAndEastYellow1:
      // line 35 "model.ump"
      trafficLightManager.westYellow();
      // line 36 "model.ump"
      trafficLightManager.eastYellow();
      // line 37 "model.ump"
      trafficLightManager.northRed();
      // line 38 "model.ump"
      trafficLightManager.southRed();
      break;
  }
}

private void setStatusModerate(StatusModerate aStatusModerate)
{
  statusModerate = aStatusModerate;
  if (status != Status.moderate && aStatusModerate != StatusModerate.Null) { setStatus(Status.moderate); }

  // entry actions and do activities
  switch(statusModerate)
  {
    case northGreenArrow2:
      // line 46 "model.ump"
      trafficLightManager.northGreenAndArrow();
      // line 47 "model.ump"
      trafficLightManager.eastRed();
      // line 48 "model.ump"
      trafficLightManager.westRed();
      // line 49 "model.ump"
      trafficLightManager.southRed();
      break;
    case northYellow2:
      // line 53 "model.ump"
      trafficLightManager.northYellow();
      // line 54 "model.ump"
      trafficLightManager.southRed();
      // line 55 "model.ump"
      trafficLightManager.eastRed();
      // line 56 "model.ump"
      trafficLightManager.westRed();
      break;
    case northRed2:
      // line 60 "model.ump"
      trafficLightManager.northRed();
      // line 61 "model.ump"
      trafficLightManager.southGreenAndArrow();
      // line 62 "model.ump"
      trafficLightManager.eastRed();
      // line 63 "model.ump"
      trafficLightManager.westRed();
      break;
    case southYellow2:
      // line 67 "model.ump"
      trafficLightManager.southYellow();
      // line 68 "model.ump"
      trafficLightManager.northRed();
      // line 69 "model.ump"
      trafficLightManager.eastRed();
      // line 70 "model.ump"
      trafficLightManager.westRed();
      break;
    case southRed2:
      // line 75 "model.ump"
      trafficLightManager.southRed();
      // line 76 "model.ump"
      trafficLightManager.northRed();
      // line 77 "model.ump"
      trafficLightManager.westGreen();
      // line 78 "model.ump"
      trafficLightManager.eastGreen();
      break;
    case westAndEastYellow2:
      // line 82 "model.ump"
      trafficLightManager.southRed();
      // line 83 "model.ump"
      trafficLightManager.northRed();
      // line 84 "model.ump"
      trafficLightManager.westYellow();
      // line 85 "model.ump"
      trafficLightManager.eastYellow();
      break;
  }
}

private void setStatusHigh(StatusHigh aStatusHigh)
{
  statusHigh = aStatusHigh;
  if (status != Status.high && aStatusHigh != StatusHigh.Null) { setStatus(Status.high); }

  // entry actions and do activities
  switch(statusHigh)
  {
    case northGreenArrow3:
      // line 93 "model.ump"
      trafficLightManager.northGreenAndArrow();
      // line 94 "model.ump"
      trafficLightManager.eastRed();
      // line 95 "model.ump"
      trafficLightManager.westRed();
      // line 96 "model.ump"
      trafficLightManager.southRed();
      break;
    case northYellow3:
      // line 100 "model.ump"
      trafficLightManager.northYellow();
      // line 101 "model.ump"
      trafficLightManager.southRed();
      // line 102 "model.ump"
      trafficLightManager.eastRed();
      // line 103 "model.ump"
      trafficLightManager.westRed();
      break;
    case northRed3:
      // line 107 "model.ump"
      trafficLightManager.northRed();
      // line 108 "model.ump"
      trafficLightManager.southGreenAndArrow();
      // line 109 "model.ump"
      trafficLightManager.eastRed();
      // line 110 "model.ump"
      trafficLightManager.westRed();
      break;
    case southYellow3:
      // line 114 "model.ump"
      trafficLightManager.southYellow();
      // line 115 "model.ump"
      trafficLightManager.northRed();
      // line 116 "model.ump"
      trafficLightManager.eastRed();
      // line 117 "model.ump"
      trafficLightManager.westRed();
      break;
    case southRed3:
      // line 121 "model.ump"
      trafficLightManager.southRed();
      // line 122 "model.ump"
      trafficLightManager.northRed();
      // line 123 "model.ump"
      trafficLightManager.westGreenAndArrow();
      // line 124 "model.ump"
      trafficLightManager.eastRed();
      break;
    case westGreenWithOutArrow3:
      // line 128 "model.ump"
      trafficLightManager.southRed();
      // line 129 "model.ump"
      trafficLightManager.northRed();
      // line 130 "model.ump"
      trafficLightManager.westGreen();
      // line 131 "model.ump"
      trafficLightManager.eastGreen();
      break;
    case westAndEastYellow3:
      // line 135 "model.ump"
      trafficLightManager.southRed();
      // line 136 "model.ump"
      trafficLightManager.northRed();
      // line 137 "model.ump"
      trafficLightManager.westYellow();
      // line 138 "model.ump"
      trafficLightManager.eastYellow();
      break;
  }
}

public void delete()
{}

@Override
public boolean moderateTraffic() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean lowTraffic() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean highTraffic() {
	// TODO Auto-generated method stub
	return false;
}

}