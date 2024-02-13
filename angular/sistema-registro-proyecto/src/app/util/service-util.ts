import { Injectable } from "@angular/core";


@Injectable({
    providedIn: 'root'
  })

export class ServiceUtil {

    public getJsonHeader(): any{
        
        const token = sessionStorage.getItem('token')

        return {
            "Content-Type":" application/json; charset=utf-8",

            "Authorization": `Bearer ${token}`
        };
    }

    public getSimpleHeader(): any{

        const token = sessionStorage.getItem('token')

        return{

            "Authorization": `Bearer ${token}`
        }
    }
}
