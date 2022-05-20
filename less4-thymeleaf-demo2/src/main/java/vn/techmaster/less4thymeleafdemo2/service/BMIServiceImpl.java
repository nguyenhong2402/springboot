package vn.techmaster.less4thymeleafdemo2.service;

import org.springframework.stereotype.Service;

import vn.techmaster.less4thymeleafdemo2.dto.BMIRequest;
import vn.techmaster.less4thymeleafdemo2.model.BMIResult;

@Service
public class BMIServiceImpl implements BMIService {
    @Override
    public BMIResult calculateBMI(BMIRequest request) {
        float bmiIndex = request.getWeight() / (request.getHeight() * request.getHeight());
        String category;
        String recommendation;
        if (bmiIndex < 15) {
            category = "Ốm đói";
            recommendation = "Đề nghị ăn bồi dưỡng thêm";
        } else if (bmiIndex < 16) {
            category = "Rất gầy";
            recommendation = "Đề nghị ăn bồi dưỡng thêm";
        } else if (bmiIndex < 18.5) {
            category = "Thiếu cân";
            recommendation = "Đề nghị ăn bồi dưỡng thêm";
        } else if (bmiIndex < 25) {
            category = "Chuẩn mực";
            recommendation = "Đề nghị luôn giữ gìn sức khỏe";
        } else if (bmiIndex < 30) {
            category = "Hơi béo";
            recommendation = "Đề nghị giảm cân nhẹ";
        } else if (bmiIndex < 35) {
            category = "Rất béo";
            recommendation = "Đề nghị giảm cân";
        } else if (bmiIndex < 40) {
            category = "Khủng long";
            recommendation = "Đề nghị giảm cân";
        } else {
            category = "Gọi cần cẩu";
            recommendation = "Đề nghị giảm cân";
        }
        // TODO: Send email to user
        return BMIResult
                    .builder()
                    .withBmiIndex(bmiIndex)
                    .withCategory(category)
                    .withRecommendation(recommendation)
                    .build();
    }

}
