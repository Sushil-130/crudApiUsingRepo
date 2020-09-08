package studyeasy.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import studyeasy.org.model.Lost;
import studyeasy.org.model.Post;
import studyeasy.org.model.User;
import studyeasy.org.service.LostService;

@RestController
@RequestMapping("/api")
public class LostController {

	@Autowired
	private LostService lostService;
	
	
	@GetMapping("/losts")
	public List<Lost> getLosts(){
		
		return lostService.getLosts();
	}
	

	
	@GetMapping("/losts/{id}")

	
	
	public Lost getLost(@PathVariable("id") int id) {
		
		
		Lost lost=lostService.getLost(id);
		
		
		return lost;
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/losts")

	public Lost addLost(@RequestBody Lost lost) {
		
		lostService.addLost(lost);
		return lost;
		
	}
	
	@PutMapping("/losts/{id}")
	
	public Lost updatedLost(@RequestBody Lost updatedLost,@PathVariable("id") int id) {
		
		updatedLost.setLostId(id);
		lostService.updatedLost(updatedLost);
		return updatedLost;
	}
	
	
	@DeleteMapping("/losts/{id}")
	
	
	public void deleteLost( @PathVariable("id")int id) {
		lostService.deleteLost(id);
	}
	
}
