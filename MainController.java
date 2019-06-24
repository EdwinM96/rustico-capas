
@Controller
public class MainController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SucursalService sucursalService;
	
	@RequestMapping("/")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginDTO", new LoginDTO());
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public String main(@RequestParam(name = "username") String user, @RequestParam(name = "password") String pass,
			HttpServletResponse response){
		
		if(usuarioService.findUsuarioyContraseña(user, pass)==null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return "not found";
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			return "ok";
		}
	}
	
}
