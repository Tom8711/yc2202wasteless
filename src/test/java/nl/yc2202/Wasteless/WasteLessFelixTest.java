package nl.yc2202.Wasteless;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.User;
import nl.yc2202.Wasteless.persistence.ClaimRepository;
import nl.yc2202.Wasteless.persistence.ClaimService;
import nl.yc2202.Wasteless.persistence.UserRepository;


@SpringBootTest
public class WasteLessFelixTest {


//	List <Claim> findAllByUser(User user);

	@Autowired
	private ClaimService cs;
	
	@MockBean
	private ClaimRepository cr;
	
	@MockBean
	private UserRepository ur;
	
	@Test
	void contextLoads() {
		Assertions.assertEquals(1,1);
		User user = new User();
		user.setEmail("hoi@daar.nl");
		Assertions.assertEquals("hoi@daar.nl", user.getEmail());
	}

	@Test
	void probeerMockRepository() {
		User u = new User();
		u.setId(3);
		Claim c = new Claim();
		List<Claim> claims = new ArrayList();
		claims.add(c);
		when(ur.findById(u.getId())).thenReturn(Optional.of(u));
		when(cr.findAllByUser(u)).thenReturn(claims);
		
		List<Claim> claimsReturn = cs.getAllClaimsDoneByUserId(u.getId());
		Assertions.assertEquals(claims, claimsReturn);
	}
}
