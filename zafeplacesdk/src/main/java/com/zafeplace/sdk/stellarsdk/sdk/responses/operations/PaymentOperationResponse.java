package com.zafeplace.sdk.stellarsdk.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import com.zafeplace.sdk.stellarsdk.sdk.Asset;
import com.zafeplace.sdk.stellarsdk.sdk.AssetTypeNative;
import com.zafeplace.sdk.stellarsdk.sdk.KeyPair;

/**
 * Represents Payment operation response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see com.zafeplace.sdk.stellarsdk.sdk.requests.OperationsRequestBuilder
 * @see com.zafeplace.sdk.stellarsdk.sdk.Server#operations()
 */
public class PaymentOperationResponse extends OperationResponse {
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;
  @SerializedName("from")
  protected final KeyPair from;
  @SerializedName("to")
  protected final KeyPair to;

  PaymentOperationResponse(String amount, String assetType, String assetCode, String assetIssuer, KeyPair from, KeyPair to) {
    this.amount = amount;
    this.assetType = assetType;
    this.assetCode = assetCode;
    this.assetIssuer = assetIssuer;
    this.from = from;
    this.to = to;
  }

  public String getAmount() {
    return amount;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      KeyPair issuer = KeyPair.fromAccountId(assetIssuer);
      return Asset.createNonNativeAsset(assetCode, issuer);
    }
  }

  public KeyPair getFrom() {
    return from;
  }

  public KeyPair getTo() {
    return to;
  }
}
