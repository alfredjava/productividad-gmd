package com.gmd.productividad.service;

import com.gmd.productividad.dao.ColaboradorDAO;
import com.gmd.productividad.domain.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * A custom service for retrieving users from a custom datasource, such as a database.
 * <p>
 * This custom service must implement Spring's {@link org.springframework.security.core.userdetails.UserDetailsService}
 */
@Transactional(readOnly = true)
@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private ColaboradorDAO colaboradorDAO;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		// Declare a null Spring User
		UserDetails user = null;
		
		try {
            Colaborador colaborador = colaboradorDAO.findByUsername(username);
            System.out.println("rol:        " + colaborador.getRol());
            GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(colaborador.getRol().charValue()=='1' ? "ROL_COLABORADOR" : "ROL_SUPERVISOR");
            //TODO: DEBE EXTRAERSE DE LA TABLA PARAMETROS

            user =  new User(
					colaborador.getUsuario(),
					colaborador.getPassword(),
					true,
					true,
					true,
					true,
                    Collections.singletonList(grantedAuthority));
		} catch (Exception e) {
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		
		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;
	}
	

}
