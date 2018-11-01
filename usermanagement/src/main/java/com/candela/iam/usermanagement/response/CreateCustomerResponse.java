package com.candela.iam.usermanagement.response;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CreateCustomerResponse
{
    private String userIdResponse;
    private String channelIdResponse;
    private String distributorIdResponse;

}

