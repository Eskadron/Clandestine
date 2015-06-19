package com.nibel.clandestine.eventserver;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/terrain/{x:[0-9]+}/{y:[0-9]+}")
public class TerrainResource {
	static File terrainFile = new File("webapp/terrain/tile.png");

	@GET
    @Produces("image/png")
	public Response getTerrain( @PathParam("x") String xParam,
							@PathParam("y") String yParam ){
//		Integer topLeftX = Integer.valueOf(xParam);
//		Integer topLeftY = Integer.valueOf(yParam);
//		
		return Response.ok(terrainFile).build();
	}
}
