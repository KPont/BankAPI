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

/**
 * REST Web Service
 *
 * @author Kasper
 */
@Path("discount")
public class DiscountResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DiscountResource
     */
    public DiscountResource() {
    }

    /**
     * Retrieves representation of an instance of khp.pba.bank.DiscountResource
     * @param nc
     * @param lc
     * @param coup
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{newcustomer}/{loyaltycard}/{coupon}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJson(@PathParam("newcustomer") String nc, @PathParam("loyaltycard") String lc, @PathParam("coupon") String coup) {
        //TODO return proper representation object
        String t = nc.toLowerCase();
        Double discount = 0.0;
        boolean isNc = nc.toLowerCase().equals("true");
        boolean isLc = lc.toLowerCase().equals("true");
        boolean isCoup = coup.toLowerCase().equals("true");
        
        if(isCoup){
            discount = 0.20;
        }
        else if(isNc){
            discount = 0.15;
        }
        else if(isLc){
            discount = 0.10;
        }
        
        JsonObject result = Json.createObjectBuilder().add("Discount", discount).build();
        return result;
    }

    /**
     * PUT method for updating or creating an instance of DiscountResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
