package vn.su.labthymlf.service;

import vn.su.labthymlf.dto.BMIRequest;
import vn.su.labthymlf.dto.BMIResult;

public interface BMIService {
    public BMIResult calculateBMI(BMIRequest request);
}
