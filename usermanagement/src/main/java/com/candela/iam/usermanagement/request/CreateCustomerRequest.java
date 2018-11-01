package com.candela.iam.usermanagement.request;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CreateCustomerRequest
{
    private String userId;
    private String channelId;
    private String distributorId;

}

