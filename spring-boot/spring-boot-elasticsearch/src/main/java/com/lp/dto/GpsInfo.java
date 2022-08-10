package com.lp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GpsInfo {

    private String id;
    private String vehicleId;
    private String deviceId;
    private String location;
    private Long gpsTime;
    private Long createTime;

}
