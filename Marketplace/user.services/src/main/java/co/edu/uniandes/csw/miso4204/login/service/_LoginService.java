/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 * ========================================================================


 Source generated by CrudMaker version 1.0.0.qualifier

 */
package co.edu.uniandes.csw.miso4204.login.service;

import co.edu.uniandes.csw.miso4204.security.jwt.api.JsonWebToken;
import co.edu.uniandes.csw.miso4204.security.jwt.api.JwtHashAlgorithm;
import co.edu.uniandes.csw.miso4204.security.logic.SecurityLogic;
import co.edu.uniandes.csw.miso4204.security.logic.dto.UserSessionDTO;
import co.edu.uniandes.csw.miso4204.user.logic.dto.LoginDTO;
import co.edu.uniandes.csw.miso4204.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.miso4204.user.logic.dto.UserPageDTO;
import co.edu.uniandes.csw.miso4204.user.logic.ejb.UserLogicService;
import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class _LoginService {

//	@Autowired
//	protected UserLogicService userLogicService;
    @Autowired
    protected SecurityLogic securityLogic;

    @POST
    @Path("/login")
    public Response login(UserSessionDTO login) {
        String token = "Usuario y contrase�a errado. Por favor, vuelva a intentarlo";

        try {
            UserSessionDTO db = securityLogic.getUserSession(login.getUserName());
            if (db != null) {
                if (db.getUserName().equals(login.getUserName()) && db.getPassword().equals(login.getPassword()) && db.getTenantID().equals(login.getTenantID())) {
                    token = new Gson().toJson(JsonWebToken.encode(db, "Ejemplo", JwtHashAlgorithm.HS256));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok().entity(token).build();
    }

    public SecurityLogic getSecurityLogic() {
        return securityLogic;
    }

    public void setSecurityLogic(SecurityLogic securityLogic) {
        this.securityLogic = securityLogic;
    }

}