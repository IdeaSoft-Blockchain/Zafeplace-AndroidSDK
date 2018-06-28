// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package com.zafeplace.sdk.stellarsdk.sdk.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct SCPStatement
//  {
//      NodeID nodeID;    // v
//      uint64 slotIndex; // i
//  
//      union switch (SCPStatementType type)
//      {
//      case SCP_ST_PREPARE:
//          struct
//          {
//              Hash quorumSetHash;       // D
//              SCPBallot ballot;         // b
//              SCPBallot* prepared;      // p
//              SCPBallot* preparedPrime; // p'
//              uint32 nC;                // c.n
//              uint32 nH;                // h.n
//          } prepare;
//      case SCP_ST_CONFIRM:
//          struct
//          {
//              SCPBallot ballot;   // b
//              uint32 nPrepared;   // p.n
//              uint32 nCommit;     // c.n
//              uint32 nH;          // h.n
//              Hash quorumSetHash; // D
//          } confirm;
//      case SCP_ST_EXTERNALIZE:
//          struct
//          {
//              SCPBallot commit;         // c
//              uint32 nH;                // h.n
//              Hash commitQuorumSetHash; // D used before EXTERNALIZE
//          } externalize;
//      case SCP_ST_NOMINATE:
//          SCPNomination nominate;
//      }
//      pledges;
//  };

//  ===========================================================================
public class SCPStatement  {
  public SCPStatement () {}
  private NodeID nodeID;
  public NodeID getNodeID() {
    return this.nodeID;
  }
  public void setNodeID(NodeID value) {
    this.nodeID = value;
  }
  private Uint64 slotIndex;
  public Uint64 getSlotIndex() {
    return this.slotIndex;
  }
  public void setSlotIndex(Uint64 value) {
    this.slotIndex = value;
  }
  private SCPStatementPledges pledges;
  public SCPStatementPledges getPledges() {
    return this.pledges;
  }
  public void setPledges(SCPStatementPledges value) {
    this.pledges = value;
  }
  public static void encode(XdrDataOutputStream stream, SCPStatement encodedSCPStatement) throws IOException{
    NodeID.encode(stream, encodedSCPStatement.nodeID);
    Uint64.encode(stream, encodedSCPStatement.slotIndex);
    SCPStatementPledges.encode(stream, encodedSCPStatement.pledges);
  }
  public static SCPStatement decode(XdrDataInputStream stream) throws IOException {
    SCPStatement decodedSCPStatement = new SCPStatement();
    decodedSCPStatement.nodeID = NodeID.decode(stream);
    decodedSCPStatement.slotIndex = Uint64.decode(stream);
    decodedSCPStatement.pledges = SCPStatementPledges.decode(stream);
    return decodedSCPStatement;
  }

  public static class SCPStatementPledges {
    public SCPStatementPledges () {}
    SCPStatementType type;
    public SCPStatementType getDiscriminant() {
      return this.type;
    }
    public void setDiscriminant(SCPStatementType value) {
      this.type = value;
    }
    private SCPStatementPrepare prepare;
    public SCPStatementPrepare getPrepare() {
      return this.prepare;
    }
    public void setPrepare(SCPStatementPrepare value) {
      this.prepare = value;
    }
    private SCPStatementConfirm confirm;
    public SCPStatementConfirm getConfirm() {
      return this.confirm;
    }
    public void setConfirm(SCPStatementConfirm value) {
      this.confirm = value;
    }
    private SCPStatementExternalize externalize;
    public SCPStatementExternalize getExternalize() {
      return this.externalize;
    }
    public void setExternalize(SCPStatementExternalize value) {
      this.externalize = value;
    }
    private SCPNomination nominate;
    public SCPNomination getNominate() {
      return this.nominate;
    }
    public void setNominate(SCPNomination value) {
      this.nominate = value;
    }
    public static void encode(XdrDataOutputStream stream, SCPStatementPledges encodedSCPStatementPledges) throws IOException {
    stream.writeInt(encodedSCPStatementPledges.getDiscriminant().getValue());
    switch (encodedSCPStatementPledges.getDiscriminant()) {
    case SCP_ST_PREPARE:
    SCPStatementPrepare.encode(stream, encodedSCPStatementPledges.prepare);
    break;
    case SCP_ST_CONFIRM:
    SCPStatementConfirm.encode(stream, encodedSCPStatementPledges.confirm);
    break;
    case SCP_ST_EXTERNALIZE:
    SCPStatementExternalize.encode(stream, encodedSCPStatementPledges.externalize);
    break;
    case SCP_ST_NOMINATE:
    SCPNomination.encode(stream, encodedSCPStatementPledges.nominate);
    break;
    }
    }
    public static SCPStatementPledges decode(XdrDataInputStream stream) throws IOException {
    SCPStatementPledges decodedSCPStatementPledges = new SCPStatementPledges();
    SCPStatementType discriminant = SCPStatementType.decode(stream);
    decodedSCPStatementPledges.setDiscriminant(discriminant);
    switch (decodedSCPStatementPledges.getDiscriminant()) {
    case SCP_ST_PREPARE:
    decodedSCPStatementPledges.prepare = SCPStatementPrepare.decode(stream);
    break;
    case SCP_ST_CONFIRM:
    decodedSCPStatementPledges.confirm = SCPStatementConfirm.decode(stream);
    break;
    case SCP_ST_EXTERNALIZE:
    decodedSCPStatementPledges.externalize = SCPStatementExternalize.decode(stream);
    break;
    case SCP_ST_NOMINATE:
    decodedSCPStatementPledges.nominate = SCPNomination.decode(stream);
    break;
    }
      return decodedSCPStatementPledges;
    }

    public static class SCPStatementPrepare {
      public SCPStatementPrepare () {}
      private Hash quorumSetHash;
      public Hash getQuorumSetHash() {
        return this.quorumSetHash;
      }
      public void setQuorumSetHash(Hash value) {
        this.quorumSetHash = value;
      }
      private SCPBallot ballot;
      public SCPBallot getBallot() {
        return this.ballot;
      }
      public void setBallot(SCPBallot value) {
        this.ballot = value;
      }
      private SCPBallot prepared;
      public SCPBallot getPrepared() {
        return this.prepared;
      }
      public void setPrepared(SCPBallot value) {
        this.prepared = value;
      }
      private SCPBallot preparedPrime;
      public SCPBallot getPreparedPrime() {
        return this.preparedPrime;
      }
      public void setPreparedPrime(SCPBallot value) {
        this.preparedPrime = value;
      }
      private Uint32 nC;
      public Uint32 getNC() {
        return this.nC;
      }
      public void setNC(Uint32 value) {
        this.nC = value;
      }
      private Uint32 nH;
      public Uint32 getNH() {
        return this.nH;
      }
      public void setNH(Uint32 value) {
        this.nH = value;
      }
      public static void encode(XdrDataOutputStream stream, SCPStatementPrepare encodedSCPStatementPrepare) throws IOException{
        Hash.encode(stream, encodedSCPStatementPrepare.quorumSetHash);
        SCPBallot.encode(stream, encodedSCPStatementPrepare.ballot);
        if (encodedSCPStatementPrepare.prepared != null) {
        stream.writeInt(1);
        SCPBallot.encode(stream, encodedSCPStatementPrepare.prepared);
        } else {
        stream.writeInt(0);
        }
        if (encodedSCPStatementPrepare.preparedPrime != null) {
        stream.writeInt(1);
        SCPBallot.encode(stream, encodedSCPStatementPrepare.preparedPrime);
        } else {
        stream.writeInt(0);
        }
        Uint32.encode(stream, encodedSCPStatementPrepare.nC);
        Uint32.encode(stream, encodedSCPStatementPrepare.nH);
      }
      public static SCPStatementPrepare decode(XdrDataInputStream stream) throws IOException {
        SCPStatementPrepare decodedSCPStatementPrepare = new SCPStatementPrepare();
        decodedSCPStatementPrepare.quorumSetHash = Hash.decode(stream);
        decodedSCPStatementPrepare.ballot = SCPBallot.decode(stream);
        int preparedPresent = stream.readInt();
        if (preparedPresent != 0) {
        decodedSCPStatementPrepare.prepared = SCPBallot.decode(stream);
        }
        int preparedPrimePresent = stream.readInt();
        if (preparedPrimePresent != 0) {
        decodedSCPStatementPrepare.preparedPrime = SCPBallot.decode(stream);
        }
        decodedSCPStatementPrepare.nC = Uint32.decode(stream);
        decodedSCPStatementPrepare.nH = Uint32.decode(stream);
        return decodedSCPStatementPrepare;
      }

    }
    public static class SCPStatementConfirm {
      public SCPStatementConfirm () {}
      private SCPBallot ballot;
      public SCPBallot getBallot() {
        return this.ballot;
      }
      public void setBallot(SCPBallot value) {
        this.ballot = value;
      }
      private Uint32 nPrepared;
      public Uint32 getNPrepared() {
        return this.nPrepared;
      }
      public void setNPrepared(Uint32 value) {
        this.nPrepared = value;
      }
      private Uint32 nCommit;
      public Uint32 getNCommit() {
        return this.nCommit;
      }
      public void setNCommit(Uint32 value) {
        this.nCommit = value;
      }
      private Uint32 nH;
      public Uint32 getNH() {
        return this.nH;
      }
      public void setNH(Uint32 value) {
        this.nH = value;
      }
      private Hash quorumSetHash;
      public Hash getQuorumSetHash() {
        return this.quorumSetHash;
      }
      public void setQuorumSetHash(Hash value) {
        this.quorumSetHash = value;
      }
      public static void encode(XdrDataOutputStream stream, SCPStatementConfirm encodedSCPStatementConfirm) throws IOException{
        SCPBallot.encode(stream, encodedSCPStatementConfirm.ballot);
        Uint32.encode(stream, encodedSCPStatementConfirm.nPrepared);
        Uint32.encode(stream, encodedSCPStatementConfirm.nCommit);
        Uint32.encode(stream, encodedSCPStatementConfirm.nH);
        Hash.encode(stream, encodedSCPStatementConfirm.quorumSetHash);
      }
      public static SCPStatementConfirm decode(XdrDataInputStream stream) throws IOException {
        SCPStatementConfirm decodedSCPStatementConfirm = new SCPStatementConfirm();
        decodedSCPStatementConfirm.ballot = SCPBallot.decode(stream);
        decodedSCPStatementConfirm.nPrepared = Uint32.decode(stream);
        decodedSCPStatementConfirm.nCommit = Uint32.decode(stream);
        decodedSCPStatementConfirm.nH = Uint32.decode(stream);
        decodedSCPStatementConfirm.quorumSetHash = Hash.decode(stream);
        return decodedSCPStatementConfirm;
      }

    }
    public static class SCPStatementExternalize {
      public SCPStatementExternalize () {}
      private SCPBallot commit;
      public SCPBallot getCommit() {
        return this.commit;
      }
      public void setCommit(SCPBallot value) {
        this.commit = value;
      }
      private Uint32 nH;
      public Uint32 getNH() {
        return this.nH;
      }
      public void setNH(Uint32 value) {
        this.nH = value;
      }
      private Hash commitQuorumSetHash;
      public Hash getCommitQuorumSetHash() {
        return this.commitQuorumSetHash;
      }
      public void setCommitQuorumSetHash(Hash value) {
        this.commitQuorumSetHash = value;
      }
      public static void encode(XdrDataOutputStream stream, SCPStatementExternalize encodedSCPStatementExternalize) throws IOException{
        SCPBallot.encode(stream, encodedSCPStatementExternalize.commit);
        Uint32.encode(stream, encodedSCPStatementExternalize.nH);
        Hash.encode(stream, encodedSCPStatementExternalize.commitQuorumSetHash);
      }
      public static SCPStatementExternalize decode(XdrDataInputStream stream) throws IOException {
        SCPStatementExternalize decodedSCPStatementExternalize = new SCPStatementExternalize();
        decodedSCPStatementExternalize.commit = SCPBallot.decode(stream);
        decodedSCPStatementExternalize.nH = Uint32.decode(stream);
        decodedSCPStatementExternalize.commitQuorumSetHash = Hash.decode(stream);
        return decodedSCPStatementExternalize;
      }

    }
  }
}
