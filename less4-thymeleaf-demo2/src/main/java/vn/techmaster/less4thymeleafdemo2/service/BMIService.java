package vn.techmaster.less4thymeleafdemo2.service;

import vn.techmaster.less4thymeleafdemo2.dto.BMIRequest;
import vn.techmaster.less4thymeleafdemo2.model.BMIResult;

public interface BMIService {
    public BMIResult calculateBMI(BMIRequest request);
}
