package com.uca.rustico.controller;

@Controller
@RequestMapping("/sucursal")
public class SucController {
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	SucursalService sucursalService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("sucursales", sucursalService.findAll());
		mav.setViewName("sucursales/main");
		return mav;
	}
	
	@RequestMapping(value = "/ver", method = RequestMethod.POST)
	public ModelAndView ver(@RequestParam(name = "editId") Integer id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("editarDTO", sucursalService.obtenerSucursalDTO(id));
		mav.setViewName("sucursales/editarSuc");
		return mav;
	}
	
	@RequestMapping(value = "/nueva", method = RequestMethod.GET)
	public ModelAndView registrar(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("editarDTO", new EditarDTO());
		mav.setViewName("sucursales/registrarSuc");
		return mav;
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute EditarDTO editarDTO, BindingResult result){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("sucursales/editarSuc");
		}else {
			sucursalService.editarSucursal(editarDTO);
			mav.setViewName("sucursales/main");
		}
		return mav;
	}
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView nuevaSucursal(@Valid @ModelAttribute EditarDTO editarDTO, BindingResult result){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("sucursales/registrarSuc");
		}else {
			sucursalService.agregarSucursal(editarDTO);
			mav.setViewName("sucursales/main");
		}
		return mav;
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@RequestParam(name = "valorId") Integer id){
		ModelAndView mav = new ModelAndView();
		sucursalService.eliminarSucursal(id);
		mav.addObject("sucursales", sucursalService.findAll());
		mav.setViewName("sucursales/main");
		return mav;
	}
}
