import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-onboarding',
  templateUrl: './onboarding.component.html',
  styleUrls: ['./onboarding.component.css']
})
export class OnboardingComponent {
  selectedRole: string = '';
  connections: string[] = [];

  expertiseRoles = [
    { value: 'development', label: 'Development' },
    { value: 'design', label: 'Design' },
    { value: 'content', label: 'Content' },
    { value: 'marketing', label: 'Marketing' }
  ];

  populateConnectionsList(): void {
    this.connections = [];

    if (this.selectedRole === 'development') {
      this.connections = ['Github', 'StackOverflow', 'LeetCode'];
    } else if (this.selectedRole === 'design') {
      this.connections = ['Behance', 'Dribbble', 'Figma'];
    } else if (this.selectedRole === 'content') {
      this.connections = ['Medium', 'Personal Blog'];
    } else if (this.selectedRole === 'marketing') {
      this.connections = ['Facebook', 'Instagram', 'Youtube'];
    }
  }

}
