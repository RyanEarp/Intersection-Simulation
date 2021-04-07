package jsjf;

import java.util.Queue;

import jsjf.IntersectionSimulation.Car;

public class IntersectionSimulation
{
	private final static int   EAST_WEST_GREEN_TIME    = 30 ;
	private final static int[] NORTH_SOUTH_GREEN_TIMES = { 20, 24, 30, 42 } ;
	private final static int[] CAR_INTERSECTION_RATES  = { 3,  5, 10 } ;
	private final static int[] CAR_QUEUEING_RATES      = { 5, 10, 30 } ;
	private final static int[] EXPERIMENT_DURATIONS    = { 3*60, 5*60, 10*60 } ;
			
	public static void main( String[] args )
	{
		System.out.println( "E/W Green  N/S Green  Int. Rate  Q. Rate  Duration  N Cars  S Cars  E Cars  W Cars" ) ;
		System.out.println( "----------------------------------------------------------------------------------" ) ;

		for( int i = 0 ; i < 4 ; ++i )
		{
			for( int j = 0 ; j < 3 ; ++j )
			{
				for( int k = 0 ; k < 3 ; ++k )
				{
					for( int l = 0 ; l < 3 ; ++l )
					{
						int northSouthGreenTime = NORTH_SOUTH_GREEN_TIMES[ i ] ;
						int carIntersectionRate = CAR_INTERSECTION_RATES [ j ] ;
						int carQueueingRate     = CAR_QUEUEING_RATES     [ k ] ;
						int experimentDuration  = EXPERIMENT_DURATIONS   [ l ] ;
						
						simulation(northSouthGreenTime, EAST_WEST_GREEN_TIME, carIntersectionRate, carQueueingRate, experimentDuration);
					}
				}
			}
		}
	}
	
	private static void simulation(int northSouthGreenTime, int eastWestGreenTime, int carIntersectionRate, int CarQueueingRate, int experimentDuration)
	{	
		boolean isNS = true;
			int greenTime = 0;
			int timeSinceCrossing = 0;
			int NSTimeSinceLastCarArrive = 0;
			int EWTimeSinceLastCarArrive = 0;
			int NScars = 0;
			int EWcars = 0;
			LinkedQueue<Car> carEWQueue = new LinkedQueue<Car>();
			LinkedQueue<Car> carNSQueue = new LinkedQueue<Car>();
		for(int timeRemaining = experimentDuration; timeRemaining> 0; timeRemaining--)
		{	
			
			NSTimeSinceLastCarArrive++;
			EWTimeSinceLastCarArrive++;
			greenTime++;
//			Step 1: Pass cars through the intersection
			if(isNS == true)
			{
				
				if(!carNSQueue.isEmpty())
				{
					if(timeSinceCrossing >= carIntersectionRate)
					{
						NScars++;
						carNSQueue.dequeue();
						timeSinceCrossing=0;
					}
					else {
						timeSinceCrossing++;
						
					}
				}
			}
			else {
				
				if(!carEWQueue.isEmpty())
				{
					if(timeSinceCrossing >= carIntersectionRate)
					{
						EWcars++;
						carEWQueue.dequeue();
						timeSinceCrossing=0;
					}
					else {
						timeSinceCrossing++;
					
					}
				}
			}
				
			if(NSTimeSinceLastCarArrive >= CarQueueingRate)
			{
				carNSQueue.enqueue(new Car());
				NSTimeSinceLastCarArrive=0;
			}
			if(EWTimeSinceLastCarArrive >= CarQueueingRate)
			{
				carEWQueue.enqueue(new Car());
				EWTimeSinceLastCarArrive=0;
			} 
			
			if(isNS == true)
			{
				if(greenTime >= northSouthGreenTime)
				{
					isNS=false;
					timeSinceCrossing = 0;
					greenTime = 0;
					NSTimeSinceLastCarArrive = 0;
					EWTimeSinceLastCarArrive = 0;
				}
			}
			else
			{
				if(greenTime >= eastWestGreenTime)
				{
					isNS=true;
					timeSinceCrossing = 0;
					greenTime = 0;
					EWTimeSinceLastCarArrive = 0;
					NSTimeSinceLastCarArrive = 0;
				}
			}
		
		
			
			
		}
		System.out.printf("%6d %9d %10d %8d %10d %8d %7d %7d %7d \n", eastWestGreenTime,northSouthGreenTime,carIntersectionRate,CarQueueingRate,experimentDuration,NScars,NScars,EWcars, EWcars);
		
	}
	
	public static class Car
	{
		//This class can be completely empty.
		// We just need *something* in our queues.
		// It's the count of items in the queues we are concerned with,
		//  not the properties of the items in the queues.
	}
}