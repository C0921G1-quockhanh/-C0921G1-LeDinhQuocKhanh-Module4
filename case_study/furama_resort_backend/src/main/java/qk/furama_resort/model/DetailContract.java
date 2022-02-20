package qk.furama_resort.model;

import javax.persistence.*;

@Entity
@Table
public class DetailContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer detailContractID;
    protected Integer quantity;

    @ManyToOne(targetEntity = Contract.class)
    private Contract contract;

    @ManyToOne(targetEntity = AccompaniedService.class)
    private AccompaniedService accompaniedService;

    public DetailContract() {
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
}
