package innova4b.empresaReparto.mensajeria;

import innova4b.empresaReparto.empleado.domain.Empleado;
import innova4b.empresaReparto.empleado.repository.EmpleadoDao;
import innova4b.empresaReparto.login.service.LoginService;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MensajeriaService {
	
	private static final Logger logger = Logger.getLogger(MensajeriaService.class);
	
	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	private MailSender mailSender;
	
	@AfterReturning(pointcut = "execution(* innova4b.empresaReparto.*.repository.*.delete(..))", returning= "id") 
	public void sendMail(JoinPoint joinPoint, int id){
		String nombreObjeto = buildObjetoName(joinPoint.toString());
		String asunto = new StringBuilder("Objeto ").append(nombreObjeto).append(" eliminado").toString(); 
		String cuerpo = new StringBuilder("El objeto ").append(nombreObjeto).append(" con id ").append(id).append(" se ha eliminado").toString();
		for (Empleado administrador : empleadoDao.listAdministradores()) {		
			SimpleMailMessage mensaje = buildMessage(administrador.getEmail(), asunto, cuerpo);
	        try{
	        	mailSender.send(mensaje);    
	        }catch(MailException me){
	        	logger.error("Error en el envio del e-mail");
	        }
	    }    
	}
	
	String buildObjetoName(String joinPoint){
		StringBuilder pointcutSB = new StringBuilder(joinPoint);
		return pointcutSB.substring(pointcutSB.indexOf("empresaReparto.")+15, pointcutSB.indexOf(".repository"));
	}
	
	private SimpleMailMessage buildMessage(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

}
