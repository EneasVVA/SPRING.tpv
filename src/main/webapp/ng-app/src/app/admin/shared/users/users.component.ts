/**
 * Created by fran lopez on 13/05/2017.
 */

import {Component, OnInit} from '@angular/core';
import {UsersService} from './users.service';
import {TPVHTTPError} from '../../../shared/models/tpv-http-error.model';
import {ToastService} from '../../../shared/services/toast.service';
import {User} from '../../../shared/models/user.model';
import {MdDialog, MdDialogConfig} from '@angular/material';
import {NewUserDialog} from './new-user/new-user.component';
import {isNull} from "util";

@Component({
    selector: 'users',
    inputs: ['endpoint', 'usersType'],
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
    results = [];
    endpoint: string;
    usersType: string;
    dialogConfig: MdDialogConfig;
    selected: User;

    constructor(private httpService: UsersService, private toastService: ToastService,
                private newUserDialog: MdDialog) {
        this.dialogConfig = new MdDialogConfig();
        this.dialogConfig.data = this.httpService;
        this.selected = new User();
    }

    ngOnInit(): void {
        this.httpService.setEndpoint(this.endpoint);
        this.httpService.findAll().subscribe(
            results => this.results = results.data,
            error => this.handleError(error)
        );
    }

    handleError(httpError: TPVHTTPError) {
        this.toastService.info('ERROR getting results from server', httpError.error);
    }

    loadResultsFound(results: User[]) {
        this.results = results;
    }

    openNewUserDialog() {
        let dialogRef = this.newUserDialog.open(NewUserDialog, this.dialogConfig);
        dialogRef.afterClosed().subscribe(user => {
            this.ngOnInit();
            console.log(user);
        });
    }

    onSelectedUser(user: User) {
        this.selected = user;
    }

    onModifiedUser(user: User) {
        if (isNull(user))
            this.httpService.delete(this.selected.mobile).subscribe(
                results => this.ngOnInit(),
                error => this.handleError(error)
            );
    }
}