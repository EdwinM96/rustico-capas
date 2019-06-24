
@Controller
@RequestMapping("/empleado")
public class EmpController {

	@Autowired
	SucursalService sucursalService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@RequestMapping(value = "/ver", method = RequestMethod.POST)
	public ModelAndView verEmpleado(@RequestParam(name = "empId2",  required = true) Integer empId, @RequestParam(name = "sucId2",  required = true) Integer sucId){
		ModelAndView mav = new ModelAndView();
		mav.addObject("editarEmpDTO", empleadoService.editEmpDTO(empId));
		mav.addObject("IdPadre", sucId);
		mav.setViewName("empleados/editarEmpleado");
		return mav;
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute EditarEmpDTO editarDTO, BindingResult result, 
			@RequestParam(name = "empId") Integer empId){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("IdPadre", empId);
			mav.setViewName("empleados/editarEmpleado");
		}else {
			empleadoService.editarEmpleado(editarDTO);
			mav.addObject("sucursal", sucursalService.findOne(empId));
			mav.setViewName("empleados/main");
		}
		return mav;
	}
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminarEmpleado(@RequestParam(name = "empId",  required = true) Integer empId, @RequestParam(name = "sucId",  required = true) Integer sucId){
		ModelAndView mav = new ModelAndView();
		empleadoService.eliminarEmpleado(empId);
		mav.addObject("sucursal", sucursalService.findOne(sucId));
		mav.setViewName("empleados/main");
		return mav;
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView registrar(@RequestParam(name = "id") Integer employeeId){
		ModelAndView mav = new ModelAndView();
		mav.addObject("IDSucursal", employeeId);
		mav.addObject("editarEmpDTO", new EditarEmpDTO());
		mav.setViewName("empleados/registrarEmpleado");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView nuevaSucursal(@Valid @ModelAttribute EditarEmpDTO editarDTO, BindingResult result,
			@RequestParam(name = "sucursalId", required = true) Integer empId){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("IDSucursal", empId);
			mav.setViewName("empleados/registrarEmpleado");
		}else {
			empleadoService.agregarEmpleado(editarDTO, empId);
			mav.addObject("sucursal", sucursalService.findOne(empId));
			mav.setViewName("empleados/main");
		}
		return mav;
	}
	@RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main(@RequestParam(name = "id") Integer id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("sucursal", sucursalService.findOne(id));
		mav.setViewName("empleados/main");
		return mav;
	}
}
