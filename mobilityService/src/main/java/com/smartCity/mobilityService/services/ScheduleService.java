package com.smartCity.mobilityService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartCity.mobilityService.DTO.ScheduleDTO;
import com.smartCity.mobilityService.entities.Schedule;
import com.smartCity.mobilityService.entities.TransportLine;
import com.smartCity.mobilityService.repositories.ScheduleRepository;
import com.smartCity.mobilityService.repositories.TransportLineRepository;


@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository repoSchedule;
	
	@Autowired TransportLineRepository repoTransportLine;
	
	public Schedule addSchedule(ScheduleDTO scheduleDTO) {
	   
	    Optional<TransportLine> line = repoTransportLine.findById(scheduleDTO.getTransportLineId());    
	     if(line.get()!=null)
	     {
	    	Schedule schedule = new Schedule();
	 	    schedule.setDepartureTime(scheduleDTO.getDepartureTime());
	 	    schedule.setArrivalTime(scheduleDTO.getArrivalTime());
	 	    schedule.setStationDepart(scheduleDTO.getStationDepart());
	 	    schedule.setStationArrivee(scheduleDTO.getStationArrivee());
	 	    schedule.setTransportLine(line.get());
	 	    Schedule savedSchedule = repoSchedule.save(schedule); 
	 	   return savedSchedule ;
	     }
	     else
	     {
	    	 return null;
	     }

	    
	    
	}

	public Optional<Schedule>  getSchedule(Long id)
	{
		return repoSchedule.findById(id);
	}
	public List<Schedule>  getAllSchedule()
	{
		return repoSchedule.findAll();
	}
	public void modifySchedule(ScheduleDTO scheduleDTO, Long id) {
	    Optional<Schedule> existingSchedule = this.getSchedule(id);
	    if (existingSchedule != null) {
	    	 Optional<TransportLine> line = repoTransportLine.findById(scheduleDTO.getTransportLineId());    
		     if(line.get()!=null)
		     {
	    	existingSchedule.get().setArrivalTime(scheduleDTO.getArrivalTime());
	    	existingSchedule.get().setDepartureTime(scheduleDTO.getDepartureTime());
	    	existingSchedule.get().setStationArrivee(scheduleDTO.getStationArrivee());
	    	existingSchedule.get().setStationDepart(scheduleDTO.getStationDepart());
	    	existingSchedule.get().setTransportLine(line.get());
	    	repoSchedule.save(existingSchedule.get());
		    }else
		    {
		    	  throw new RuntimeException("Transport line  with id " + id + " not found");
		    }
	    } else {
	        throw new RuntimeException("Schedule with id " + id + " not found");
	    }
	}
	public void  deleteSchedule(Long id)
	{
		repoSchedule.deleteById(id);
	}
	public String corresspondance(Long idSchedule1,Long idSchedule2 )
	{
		Optional<Schedule> schedule = repoSchedule.findById(idSchedule1);
		Optional<Schedule> schedule2 = repoSchedule.findById(idSchedule2);
		if(schedule!=null && schedule2!=null)
		{
			if(schedule.get().getTransportLine().getType()!=schedule2.get().getTransportLine().getType())
			{
				if(schedule.get().getDepartureTime()==schedule2.get().getDepartureTime())
				{
				   return "First transport line's Departure time  correspond at second transport line Departure time ";
				}
				if(schedule.get().getArrivalTime()==schedule2.get().getArrivalTime())
				{
					return "First transport line's arrival time  correspond at second transport line arrival time";
				}
			}
		}
		return "The two lines don't corresspond in order of time";
		
	}

}
