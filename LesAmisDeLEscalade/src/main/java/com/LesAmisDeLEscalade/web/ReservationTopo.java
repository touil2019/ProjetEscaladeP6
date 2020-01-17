package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.LesAmisDeLEscalade.dao.ReservationTopoRepository;

@Controller
public class ReservationTopo {

	@Autowired
	public ReservationTopoRepository reservationtopoRepository;
}
