package com.dthvinh.rs;

import com.dthvinh.dto.RecordResponse;
import com.dthvinh.enums.Activity;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Path("/bio-clock")
public class BiologicalClockResource {

    @POST
    @Path("/record/{activity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recordWakeupOrSleepTime(@PathParam("activity") String activity) {
        String userTimezone = getUserTimezone();
        Activity validActivity = Activity.from(activity);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(userTimezone));
        Instant instant = zonedDateTime.toInstant();
        RecordResponse response = new RecordResponse(userTimezone, instant.toString(), validActivity);
        return Response.ok(response).build();
    }

    private String getUserTimezone() {
        return ZoneId.systemDefault().getId();
    }
}
