/*
 *
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.bage.study.micro.services.eureka.client4;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.niws.client.http.RestClient;

import java.net.URI;
import java.util.List;

@SuppressWarnings({ "deprecation"})
public class RibbonRestClient {

	static RestClient client ;

	static {
		try {

			ConfigurationManager.loadPropertiesFromResources("ribbon-config-default.properties");
			System.out.println(ConfigurationManager.getConfigInstance().getProperty("liems-gateway.ribbon.listOfServers"));
			client = (RestClient) ClientFactory.getNamedClient("liems-gateway");  // 2

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String executeWithLoadBalancer(List<InstanceInfo> list,String url) {
		String res = "";
		HttpResponse response = null;
		try {
			StringBuilder listOfServers = new StringBuilder();
			InstanceInfo instanceInfo = null;
			for (int i = 0; i < list.size(); i++) {
				instanceInfo  = list.get(i);

				listOfServers.append(instanceInfo.getHostName());
				listOfServers.append(":");
				listOfServers.append(instanceInfo.getPort());

				if(i > 0) { // 不是第一个
					listOfServers.append(",");
				}
			}

			System.out.println("listOfServers::" + listOfServers.toString());
			ConfigurationManager.getConfigInstance().setProperty(
					"liems-gateway.ribbon.listOfServers", listOfServers.toString()); // 5

			response = client.executeWithLoadBalancer(HttpRequest.newBuilder().uri(new URI(url)).build());  // 3

			res = response.getEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return res;
	}

	public static String executeWithLoadBalancer(String serviceId ,String url) {
		List<InstanceInfo> list = DiscoveryManager.getInstance().getDiscoveryClient().getInstancesById(serviceId);
		return executeWithLoadBalancer(list,url);
	}

}
