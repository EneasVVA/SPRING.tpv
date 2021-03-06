/**
 * @author Fran lopez
 *
 * @author Sergio Banegas Cortijo
 * Github: https://github.com/sergiobanegas
*/
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ToastyModule} from 'ng2-toasty';
import {AppComponent} from './app.component';
import {WelcomeModule} from './welcome/welcome.module';
import {OrderTrackingModule} from './order-tracking/order-tracking.module';
import {HomeModule} from './home/home.module';
import {AdminModule} from './admin/admin.module';
import {AppRoutingModule} from './app-routing.module';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        WelcomeModule,
        OrderTrackingModule,
        HomeModule,
        AppRoutingModule,
        BrowserModule,
        ToastyModule,
        AdminModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
