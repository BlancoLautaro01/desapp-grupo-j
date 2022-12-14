package ar.edu.unq.desapp.grupoj.desapp.service;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.UserRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InitServiceInMemory {

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initialize() {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
            fireInitialData();
        }
    }

    private void fireInitialData() {
        UserRequest user = new UserRequest("Pepe", "Pepa", "unaPassw123?2?", "email@gmail.com","San Martin 183", "1234567891234567891233", "12345673");
        UserRequest user2 = new UserRequest("Samanta", "Quiroga", "unaPassw123??", "email2@gmail.com","San Martin 185", "1234567891234567891234", "12345678");

        userService.register(user);
        userService.register(user2);
    }
}


