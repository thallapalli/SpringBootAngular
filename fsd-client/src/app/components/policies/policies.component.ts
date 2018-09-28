import { Component, OnInit } from '@angular/core';
import { PolicyService } from '../../services/policy.service';

@Component({
  selector: 'app-policies',
  templateUrl: './policies.component.html',
  styleUrls: ['./policies.component.css']
})
export class PoliciesComponent implements OnInit {

  policies:Array<any>;
  constructor(private policyervice: PolicyService) { }

  ngOnInit() {
  this.policyervice.getAll().subscribe(data => {
      this.policies = data;
    });
  }

}
