package com.nibel.clandestine.eventserver;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("world_updates")
public class WorldUpdateResource {
	int x = 10;
	int y = 10;
	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getEventsFollowingEntity(){
		final EventOutput eventOutput = new EventOutput();
		new Thread(new Runnable() {
			
			public void run() {
				while(true){
					final OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
                    eventBuilder.name("message");
                    
                    JSONArray entityList = new JSONArray();
                    JSONObject entityData = new JSONObject();
                    entityList.put(entityData);
                    
                    entityData.put("entityId", "1");
                    
                    JSONObject position = new JSONObject();
                    position.put("x", x);
                    position.put("y", y);
                    
                    x += (int)(Math.random() * 3.99) - 2;
                    y += (int)(Math.random() * 3.99) - 2;
                    
                    entityData.put("position", position);
                    
                    eventBuilder.data(String.class, entityList.toString());
                    final OutboundEvent event = eventBuilder.build();
                    try {
                        if(eventOutput.isClosed()){
                        	return;
                        }
						eventOutput.write(event);
						Thread.sleep(1000);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}}).start();
		return eventOutput;
	}
}
