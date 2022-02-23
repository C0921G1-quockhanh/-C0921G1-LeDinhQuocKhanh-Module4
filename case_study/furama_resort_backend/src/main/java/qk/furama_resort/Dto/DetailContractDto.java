package qk.furama_resort.Dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import qk.furama_resort.model.AccompaniedService;
import qk.furama_resort.model.Contract;

public class DetailContractDto implements Validator {

    protected Integer detailContractID;

    protected Integer quantity;

    private Contract contract;
    private AccompaniedService accompaniedService;

    public DetailContractDto() {
    }

    public Integer getDetailContractID() {
        return detailContractID;
    }

    public void setDetailContractID(Integer detailContractID) {
        this.detailContractID = detailContractID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return DetailContractDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DetailContractDto detailContractDto = (DetailContractDto) target;

        Integer quantity = detailContractDto.quantity;

        if (quantity == null)
            errors.rejectValue("quantity","quantity.null");
        else {
            if (quantity <= 0)
                errors.rejectValue("quantity","quantity.positive");
        }
    }
}
