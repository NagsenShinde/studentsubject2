package studentSubject.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import studentSubject.entity.StudentInfoEntity;
import studentSubject.repository.StudentInfoRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentInfoRepo studentInfoRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<StudentInfoEntity> studentInfoEntity = studentInfoRepo.findByStudentName(username);
        return studentInfoEntity.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        
	}

}
