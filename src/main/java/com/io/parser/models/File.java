package com.io.parser.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class File {

  private int partnId;
  private String partVal;
  private String invnCtlNbr;
  private String icnSufxCD;
  private String procDT;
  private String proTM;
  private int icnSufxVerNbr;
  private String diagSeqNbr;
  private String dedSeqNbr;
  private String clmErrCd;
  private String pdAmtRducCatgyId;
  private int lnId;
  private int origHdrSeqNbr;
  private int clmPnltySeqNbr;
  private int procSeqNbr;
  private int prortSeqNbr;
  private int provSeqNbr;
  private String clmRarcCd;
  private String clmrmrmCd;
  private String lnAccumTypCd;
  private String lnBenTypCd;
  private int cobLnSeqNbr;
  private String clmLnErrCd;
  private String seqNbr;
  private int lnPnltySeqNbr;
  private String clmLnRarcCd;
  private String clmLnRmrkCd;
  private int lnRelClmSeqNbr;
  private String lnRelClmRsnCd;
  private String relSrvcRsnTypCd;
  private String chkSrsDesg;
  private String chkNbr;
  private String accumTypCd;
  private String benTypCd;
  private int empId;
  private int eligDepnNbr;
  private String polNbr;
  private String unetServcCatgyCd;
  private String plnYrStrtDt;
  private String drftNbr;
  private String bnkCd;
  private String topsEngCd;
  private int topsDrftSeqNbr;
  private String icnDrftSeqNbr;

}
