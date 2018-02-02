- Best possible seats are the ones that are nearest to the stage and preference reduces as the distance from stage increases.
- We have a back end running Thread to release objects that are HELD after certain threshhold value specified.
- Using lock object in TicketServiceImpl.java serializes the requests but this is required to hold and modify METADATA 
  information at Auditorium, Seat and Row level objects. This metadata effectively IMPROVES RUN TIME.
- This solution holds effective for a single node as there is time limitation to implement a DISTRIBUTED 
  CACHE solution or a file system lock to cater to multi-node scenario.
- AppTimerTask.java class is scheduled to release seats held over a certain period of time on the backend. 
- Assuming a 3  x 3  size auditorium for simplicity. 

 

