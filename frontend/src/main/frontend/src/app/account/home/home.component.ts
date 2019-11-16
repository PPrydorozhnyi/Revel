import { Component, Input, ViewChild } from "@angular/core";
import { Profile } from "../profile";
import { AccountService } from "../account.service";
import { Router } from "@angular/router";
import { FriendService } from "../friends/friend.service";
import { ModalWindow } from "../../modal.window/modal.window.component";

@Component({
  selector: 'home-comp',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent{
  @Input() states: string;
  profile: Profile;
  friendRequests: number;

  @ViewChild(ModalWindow) childComponent: ModalWindow;
  constructor(
    private accountService: AccountService,
              private router: Router,
    private friendService: FriendService
  ) {
    this.profile = new Profile();
  }

  ngOnInit() {
    this.profile = JSON.parse(localStorage.getItem('currentUser'));
    this.updateRequests();
  }

  logout() {
    localStorage.clear();
    this.router.navigate(["/login"]);
  }

  logoutClick() {
    this.childComponent.show();
  }

  updateRequests() {
    this.friendService.getFriendsRequests().subscribe(requests => this.friendRequests = requests.length);
  }
}
