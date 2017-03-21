/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khp.pba.bank;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.*;

/**
 * REST Web Service
 *
 * @author Kasper
 */
@Path("interest")
public class InterestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InterestResource
     */
    public InterestResource() {
    }

    /**
     * Retrieves representation of an instance of khp.pba.bank.InterestResource
     * @param account
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{account}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("account") String account) {
        Double d = Double.parseDouble(account);
        Double interest;
        if(d < 100){
            interest = 0.03;
        }
        else if(d >= 100 && d < 1000){
            interest = 0.05;
        }
        else{
            interest = 0.07;
        }
        JsonObject result = Json.createObjectBuilder().add("Interest", (d * interest)).build();
        return result.toString();
    }

    /**
     * PUT method for updating or creating an instance of InterestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
